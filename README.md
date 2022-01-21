- 문제 설명

예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

<br/>

- 힌트

문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.

```java
String value = scanner.nextLine();
String[] values = value.split(" ");
```

문자열을 숫자로 변경하는 방법

```java
int number = Integer.parseInt("문자열");
```