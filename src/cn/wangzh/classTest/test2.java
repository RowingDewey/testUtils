package cn.wangzh.classTest;

public class test2 {
	public static void main(String[] args) {
		ModelTest model = new ModelTest("小明", "12");
		String name = model.getName();
		name = "小亮";
		model.setName(name);
		System.out.println("名字：" +model.getName() + "  年龄：" + model.getAge());
	}

}
