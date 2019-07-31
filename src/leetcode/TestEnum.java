package leetcode;

public enum TestEnum {

    test1(1,1),
    test2(2,2),
    test3(3,3);


    TestEnum(int code, int status) {
        this.code = code;
        this.status = status;
    }

    private int code;
    private int status;

    public int getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
