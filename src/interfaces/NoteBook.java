package interfaces;

public class NoteBook extends Note{

    public NoteBook find(){
        return new NoteBook(); //这里说明子类重写父类方法时，返回类型可以是父类返回类型的子类(即协变类型)。
    }
}
