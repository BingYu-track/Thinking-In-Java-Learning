package exceptions;

/**
 * @version 1.0
 * @Description: 异常链
 * @author: hxw
 * @date: 2018/7/15 22:16
 */
public class DynamicFields {

    private Object[][] fields;
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];  //生成多个包含2个对象的一维数组的二维数组
        for(int i = 0; i < initialSize; i++) //遍历二维数组并一一赋值
            fields[i] = new Object[] { null, null };
    }

    //重写toString方法
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    //判断是否存在该id，有返回其所在二维数组的下标，否则返回-1(二维数组中每一个一维数组的第一个元素作为id)
    private int hasField(String id) {
        for(int i = 0; i < fields.length; i++){
            if(id.equals(fields[i][0])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据id返回其对应的下标，没有该id就报异常
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if(fieldNum == -1){
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    /**
     * 设置id，若容量不够二维数组会自动扩容(长度加1)
     * @param id
     * @return
     */
    private int makeField(String id) {
        //如果二维数组fields里有空的一维数组(第一个元素为null)，就将id赋给该一维数组并返回在二维数组的下标
        for(int i = 0; i < fields.length; i++){
            if(fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        //执行到这里，说明二维数组fileds中没有空的一维数组，那么就新增一个比fields多一个长度的二维数组tmp
        Object[][] tmp = new Object[fields.length + 1][2];
        //将fields中已有的元素都copy一份给二维数组tmp
        for(int i = 0; i < fields.length; i++){
            tmp[i] = fields[i];
        }
        //再将初始化新增的数组
        for(int i = fields.length; i < tmp.length; i++){
            tmp[i] = new Object[] { null, null };
        }
        fields = tmp;
        //回调
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    /**
     * 将id和对应的值放入fields中
     * @param id
     * @param value
     * @return
     * @throws DynamicFieldsException
     */
    public Object setField(String id, Object value) throws DynamicFieldsException {
        if(value == null) {
            // 大多数异常没有 "cause"的构造函数.在这种情况下，必须在所有Throwable子类中使用initCace()
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());  //这里调用initCause()将原始异常NullPointerException的信息保留了下来
            throw dfe;
        }
        int fieldNumber = hasField(id); //是否存在该id
        if(fieldNumber == -1){ //如果没有当前id就将其设置进去并返回其对应的下标
            fieldNumber = makeField(id);
        }
        Object result = null;
        try {
            result = getField(id); //获取id对应的值 Get old value
        } catch(NoSuchFieldException e) {
            // 使用带有"cause"的构造器
            throw new RuntimeException(e);
        }
        //将只也设置进去
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3); //初始化(主要对fields字段进行了赋值)
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getField(\"d\") : " + df.getField("d"));
            Object field = df.setField("d", null); // Exception
        } catch(NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch(DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}
