## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```
요구사항
사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

힌트
문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.
String value = scanner.nextLine();
String[] values = value.split(" ");
문자열을 숫자로 변경하는 방법
int number = Integer.parseInt("문자열");

- 단순 계산기(SimpleCalculator)
    - [x] 주어진 사칙연산기호를 통해 두 개의 숫자를 계산한다.
    - 사칙연산 기호(symbol)
    - [x] `+`->두 개의 숫자를 덧셈
    - [x] `-`->두 개의 숫자를 뺄셈
    - [x] `*`->두 개의 숫자를 곱셈
    - [x] `/`->두 개의 숫자를 나눗셈
        - [x] 0으로 나누면 throw new ArithmeticException();

- 방정식 (Equation)
    - [x] 문자열을 문자들로 분리
    - [x] 분리된 문자들 중 숫자만 반환
    - [x] 분리된 문자들 중 연산기호만 반환

- 문자열 계산기()
    - [ ] 문자열 변환기와 단순 계산기를 통해 계산된 결과를 보여준다.
