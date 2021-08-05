import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    @AllArgsConstructor
    @NoArgsConstructor
    static class Demo{
        private Integer i;

    }

    public static void main(String[] args){

        TryCatchDemo demo = new TryCatchDemo();
        System.out.println(demo.calculate("err"));
        System.out.println(demo.calculate("right"));

        List<Demo> demoList = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            demoList.add(Demo.builder().i(10).build());
        }
        for (Demo demo1 : demoList){
            demo1 = demo1.toBuilder().i(demo1.getI() * 100).build();
        }
        demoList.forEach(System.out::println);
    }

}
