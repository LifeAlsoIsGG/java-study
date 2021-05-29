package dataStructure;


import java.util.*;

/**
 * @Package: sort
 * @Author: Chen Long
 * @Description: 手写线性表，仿ArrayList
 * @Datetime: 2021/5/3 21:13:51
 */
public class SequenceList<T> implements Iterable<T>{
    //默认容量
    private int default_capacity = 10;

    //定义一个数组保存线性表的元素
    public Object[] elementData;

    //保存元素个数
    private int size;

    //迭代器指针
    private int next;

    /**
     * @description: 普通构造器
     **/
    public SequenceList(){
        elementData = new Object[default_capacity];
    }

    /**
     * @param capacity:
     * @description: 根据指定容量大小构造
     **/
    public SequenceList(int capacity){
        elementData = new Object[capacity];
    }

    /**
     * 表长
     * @return
     */
    public int length(){
        return size;
    }

    /**
     * @description: 判断是否为空
     **/
    public Boolean isEmpty(){
        return size == 0;
    }

    /**
     * 清空线性表
     */
    public void clear(){
        //直接让所有元素指向null
        Arrays.fill(elementData, null);
        size = 0;
    }

    /**
     * @param index:
     * @description: 泛型处理
     **/
    T elementData(int index) {
        return (T) elementData[index];
    }

    /**
     * @param index:
     * @description: 判断是否越界
     **/
    public void rangeCheck(int index){
        //因为线性表中的数组有空余容量index有值，而对外的时候是按元素数量来判断是否越界
        if(index >= size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
    }

    /**
     * @param index:
     * @description: 插入时判断是否越界
     **/
    public void rangeCheckForAdd(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界异常");
        }
    }

    /**
     * 得到线性表存储的对象
     * @param index 获得的位置
     * @return  得到的结果
     */
    public T get(int index){
        rangeCheck(index);
        return elementData(index);
    }


    /**
     * 确保数组所需长度大于数组原有长度
     * @param minCapacity 数组所需长度
     */
    private void ensureCapacityInternal(int minCapacity){
        if(minCapacity > elementData.length){
            int capacity = elementData.length + (elementData.length >> 1);
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    /**
     * 直接向顺序表中插入元素
     * @param element   待插入的元素
     */
    public Boolean add(T element){
        return add(element, size);
    }

    /**
     * 向顺序表中插入元素
     * @param element   待插入的元素
     * @param index 待插入的位置
     */
    public Boolean add(T element, int index){
        //检查是否越界
        rangeCheckForAdd(index);

        //保证容量
        ensureCapacityInternal(size + 1);

        //通过复制把index以后的元素都后移一位
        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        elementData[index] = element;
        size++;
        return true;
    }


    /**
     * 删除指定位置的元素
     * @param index
     */
    public T remove(int index){
        rangeCheck(index);

        T oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        // clear to let GC do its work
        elementData[--size] = null;
        return oldValue;
    }

    //遍历
    @Override
    public Iterator<T> iterator() {
        return new STerator();
    }


    private class  STerator implements Iterator{
        //指向下一个的元素
        private int next;

        //初始化为0
        public STerator() {
            this.next = 0;
        }


        @Override
        public boolean hasNext() {
            return next != size;
        }

        @Override
        public Object next() {
            return elementData(next++);
        }
    }


    public static void main(String[] args) {
/*        SequenceList<Student> students = new SequenceList<>();
        for (Student stu : Student.getArray()){
            students.add(stu);
            students.add(stu);
            students.add(stu);
            students.add(stu);
        }

        System.out.println(students.length());
        System.out.println(students.elementData.length);
        students.add(new Student(), 15);
        System.out.println(students.get(15));

        System.out.println("遍历");
        for (Student stu : students){
            System.out.println(stu);
        }

        Iterator<Student> iterator = students.iterator();

        Map<Object, Object> objectObjectHashMap = Collections.synchronizedMap(new HashMap<Object, Object>()) ;

        ArrayList<Student> objects = new ArrayList<>();*/
    }


}
