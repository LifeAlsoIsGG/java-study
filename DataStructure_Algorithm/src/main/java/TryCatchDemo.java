import lombok.Builder;
import lombok.Data;

/**
 * @author Long Chen
 * @description
 * @date 2021-07-23 15:37
 */

class TryCatchDemo {

    public int calculate(String code) {

        int val;
        try {
            val = 0;
            if ("err".equals(code)) {
                throw new RuntimeException("Invalid");
            } else {
                val = 1;
                return val;
            }
        } catch (Exception e) {
            val = 2;
            return val;
        } finally {
            System.out.print("重新给val赋值");
            val = 3;
        }
    }

    @Data
    @Builder(toBuilder = true)
    static class Demo{
        private Integer i;
    }

    public static void main(String[] args) {

        TryCatchDemo demo = new TryCatchDemo();
        System.out.println(demo.calculate("err"));
        System.out.println(demo.calculate("right"));

        Demo demo1 = Demo.builder().i(10).build();
        System.out.println(demo1.getI());

        demo1 = demo1.toBuilder().i(20).build();
        System.out.println(demo1.getI());

    }

}
