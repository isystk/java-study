# 🌙 java-study

====

## 📗 Description

Javaの今どきの書き方を纏めました。

### 匿名クラス
https://github.com/isystk/java-study/tree/master/src/main/anonymousClass
```java
        TaskHandler taskHandler = new TaskHandler() {
            @Override
            public void handle(String message) {
                System.out.println(message);
            }
        };
        taskHandler.handle("hello");
```

### ジェネリクス
https://github.com/isystk/java-study/tree/master/src/main/genericStack
```java
// E は Numberクラスまたはそのサブクラスに制限することができる
public class NumberStack<E extends Number> {
    private List<E> taskList;

    public NumberStack() {
        // ダイヤモンドオペレーターを利用して型を簡略化できる
        taskList = new ArrayList<>();
    }

    public boolean push(E task) {
        System.out.println("Add:" + task.intValue());
        return taskList.add(task);
    }

    public E pop() {
        if (taskList.isEmpty()) {
            return null;
        }
        return taskList.remove(taskList.size()-1);
    }
}
```

### Comparator
https://github.com/isystk/java-study/tree/master/src/main/comparator
```java

        List<Student> studentList = Arrays.asList(
            new Student("Saito", 70),
            new Student("Yamada", 30),
            new Student("Ise", 100));

        // スコアの昇順でソート処理
        Collections.sort(studentList,
                (student1, student2) ->
                        Integer.compare(student1.getScore(), student2.getScore())
        );

```

### Stream 
https://github.com/isystk/java-study/tree/master/src/main/stream
```java

        new ArrayList<Student>() {
            {
                add(new Student("Moriya", 80));
                add(new Student("Saito", 70));
                add(null);
                add(new Student("Yanamoto", 60));
                add(new Student("Yamada", 30));
                add(new Student("Ise", 100));
            }}
            .stream()
                // nullを除外
                .filter(s -> Objects.nonNull(s))
                // スコアが７０以上に絞る
                .filter(s -> s.getScore() >= 70)
                .forEach(System.out::println);

        System.out.println();

        new HashMap<>() {
            {
                put("Moriya", 80);
                put("Saito", 70);
                put("Yanamoto", 60);
                put("Yamada", 30);
                put("Ise", 100);
            }
        }.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
```

### StreamMap
https://github.com/isystk/java-study/tree/master/src/main/streamMap
```java

        // ２つのグループを統合
        List<Student> top3List = Arrays.asList(group1, group2)
            .stream()
            .flatMap(g -> g.getStudents().stream())
            .sorted((s1, s2) -> s2.getScore() - s1.getScore()) // スコアの高い順にソート
            .filter(s -> s.getScore() > 50) // スコアが50より大きい人のみ
            .limit(3) // 上位3件を表示
            .collect(Collectors.toList());
        top3List.stream().forEach(System.out::println);

        System.out.println();

        // DTOのリストからnameだけのリストを生成する
        List<String> top3NameList = top3List.stream()
            .map((s) -> s.getName())
            .collect(Collectors.toList());
        top3NameList.stream().forEach(System.out::println);

        System.out.println();

        // NameをCSVとして出力
        String csv = top3NameList.stream()
                .collect(Collectors.joining(","));
        System.out.println(csv);

        System.out.println();

        // DTOのリストからMapを生成する
        Map<String, Student> top3NameMap = top3List.stream()
            .collect(Collectors.toMap(
                s -> s.getName(),
                s -> s));
        top3NameMap.entrySet().stream()
            .forEach(e -> System.out.println(e.getKey() + "→" + e.getValue()));

        System.out.println();

        // Nameのリストから配列を生成する
        String[] top3Names = top3NameList.stream()
            .toArray(String[]:: new);
        Arrays.asList(top3Names).stream().forEach(System.out::println);
```

### try with resource
https://github.com/isystk/java-study/tree/master/src/main/tryWithResource
```java

        try (BufferedReader br = Files.newBufferedReader(Paths.get("src/tryWithResource/sample.csv"))) {

            List<String> list = br.lines().collect(Collectors.toList());
            list.stream()
                    .map(line -> {
                        String name = line.split(",")[0];
                        int score = Integer.valueOf(line.split(",")[1]);
                        return score;
                    })
                    .forEach(System.out::println);

        } catch (IOException |
                NumberFormatException e) {
            e.printStackTrace();
        }

```

### Optional
https://github.com/isystk/java-study/tree/master/src/main/optional
```java
        String data = null;
        Optional<String> optional = Optional.ofNullable(data);

        // この時点ではdataが空なのでoptionalはEmptyとなっている。
        String optionalElement = optional.orElse("empty");
        System.out.println(optionalElement);

        data = "hoge";
        optional = Optional.ofNullable(data);

        // optionalが空じゃない場合にIF文の中が処理される
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        // ifPresent を利用するとIF文を簡略化することもできる
        optional.ifPresent(System.out::println);
```

### String join
https://github.com/isystk/java-study/tree/master/src/main/stringJoin
```java

        // StringBuilderはもう使わない
        String builder = String.join(
                System.lineSeparator(),
                "111",
                    "222",
                    "333",
                    "444");
        System.out.println(builder);
```

### BeanUtils.copyProperties
https://github.com/isystk/java-study/tree/master/src/main/beanCopy
```java

        Group group1 = new Group();
        group1.setClassName("Aクラス");
        group1.setRegistTime(LocalDateTime.now());
        group1.setStudents(List.of(new Student("Ise", 100),
                new Student("Moriya", 80),
                new Student("Saito", 70)));

        // Group1の値をGroup2にディープコピー
        Group group2 = new Group();
        BeanUtils.copyProperties(group2, group1);
        System.out.println(group2);
```

## 🎫 Licence

[MIT](https://github.com/isystk/java-springboot-gradle/blob/master/LICENSE)

## 👀 Author

[isystk](https://github.com/isystk)


