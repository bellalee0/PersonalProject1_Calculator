package lv3_calculator;

// 람다를 실행할 익명 클래스 생성
@FunctionalInterface
public interface Calculate {
    int calculate(int a, int b);
}