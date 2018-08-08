package cn.wangzh.test;

import java.awt.*; //为了使用布局管理器   
import java.awt.event.*;//用来处理事件   
import javax.swing.*; //最新的GUI组件   
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*; //读写文件用   
import java.util.ArrayList;
import java.util.List;

public class FileSearch{

	private JFrame frm;
	private JButton open;
	private JButton read;
	private JPanel p;
	private JPanel p1;
	private File f;
	private JTextArea textArea;
	private JFileChooser fc;
	private int flag;
	static int countFiles = 0;// 声明统计文件个数的变量
	static int countFolders = 0;// 声明统计文件夹的变量

	public FileSearch() {
		
		frm = new JFrame("java");
		open = new JButton("open");
		read = new JButton("read");
		p = new JPanel();
		p1 = new JPanel();
		textArea = new JTextArea("搜索结果：",26,90);
		Font font = new Font("宋体",Font.PLAIN,15);
		textArea.setFont(font);
		//textArea.setLineWrap(true);
		//textArea.setWrapStyleWord(true); //设置自动换行
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		//fc.setMultiSelectionEnabled(true);//设置选取多个文件    按住ctrl
		
		//设置文件过滤
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(".xml&.properties文件", "xml","properties");
		//FileNameExtensionFilter filter = new FileNameExtensionFilter(".properties文件", "properties");
		fc.setFileFilter(xmlfilter);
		//fc.setFileFilter(filter);

		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(p,BorderLayout.CENTER);
		c.add(p1,BorderLayout.NORTH);
		
		p1.setLayout(new FlowLayout());
		p1.add(open);
		p1.add(read);
		
		//p.setLayout(new BorderLayout());
		p.add(new JScrollPane(textArea));
		
		
		//p.add(read);

		// 注册按钮事件
		open.addActionListener(new action());
		//read.addActionListener(new action());
		frm.setLocation(350, 300);
		frm.setSize(800, 600);
		frm.setVisible(true);
		// 设置默认的关闭操作
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	// 打开文件
	private void openFile() 
	{
		// 设置打开文件对话框的标题
		fc.setDialogTitle("Open File");

		// 这里显示打开文件的对话框
		try {
			flag = fc.showOpenDialog(frm);
		} catch (HeadlessException head) {

			System.out.println("Open File Dialog ERROR!");
		}

		// 如果按下确定按钮，则获得该文件。
		if (flag == JFileChooser.APPROVE_OPTION) {
			// 获得该文件
			f = fc.getSelectedFile();
			//System.out.println("open file----" + f.getName()+f.getPath());
			String path = f.getPath();
			System.out.println(path);
			
			path = path.replaceAll("\\\\", "/");
			System.out.println(path);		
			File floder = new File(path+"/WEB-INF/classes/portal/common");
			
			
			if (!floder.exists()) {// 如果文件夹不存在
	            System.out.println("目录不存在：" + floder.getAbsolutePath());
	            textArea.setText("未搜索到指定文件！！！"+"\n"+"目录不存在：" + floder.getAbsolutePath());
	            return;
	        }
	        File[] result = searchFile(floder, "ps-dispatcher-config.xml");// 调用方法获得文件数组
	        
	        
	        System.out.println("在 " + floder + " 以及所有子文件时查找对象" + "ps-dispatcher-config.xml");
	        System.out.println("查找了" + countFiles + " 个文件，" + countFolders
	                + " 个文件夹，共找到 " + result.length + " 个符合条件的文件：");
	        
	        StringBuilder filepath = new StringBuilder();
	        for (int i = 0; i < result.length; i++) {// 循环显示文件
	            File file = result[i];
	            
	            System.out.println(file.getAbsolutePath() + " ");// 显示文件绝对路径
	            filepath.append(file.getAbsolutePath()+"\n");
	           
	        }
	        if(filepath.toString().equals(""))
	        {
	        	textArea.setText("未搜索到指定文件！！！");
	        }else{
	        	textArea.setText("搜索到指定文件如下："+"\n"+filepath.toString());
	        }
	        
		}
	}
	
	//查找文件
	 public static File[] searchFile(File folder, final String keyWord) 
	    {
	    	// 递归查找包含关键字的文件
	        File[] subFolders = folder.listFiles(new FileFilter() {// 运用内部匿名类获得文件
	                    public boolean accept(File pathname) {// 实现FileFilter类的accept方法
	                        if (pathname.isFile())// 如果是文件
	                            countFiles++;
	                        else
	                            // 如果是目录
	                            countFolders++;
	                        if (pathname.isDirectory()
	                                || (pathname.isFile() && pathname.getName().equals(keyWord)))// 目录或文件包含关键字
	                            return true;
	                        return false;
	                    }
	                });
	         
	        List result = new ArrayList();// 声明一个集合
	       
	        // 循环显示文件夹或文件
	        if(subFolders !=null)
	        {
	        	for (int i = 0; i < subFolders.length; i++)
	        	{
	        		if (subFolders[i].isFile())    // 如果是文件则将文件添加到结果列表中
	        		{
	        			result.add(subFolders[i]);
	        		} else {                      // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
	        			File[] foldResult = searchFile(subFolders[i], keyWord);
	        			for (int j = 0; j < foldResult.length; j++)    // 循环显示文件
	        			{
	        				result.add(foldResult[j]);        // 文件保存到集合中
	        			}
	        		}
	        	}
	        }
	         
	        File files[] = new File[result.size()];// 声明文件数组，长度为集合的长度
	        result.toArray(files);// 集合数组化
	        return files;
	    }
	 
	 
	 // 保存文件
	private void readFile()
	{
		String fileName;

		// 设置保存文件对话框的标题
		fc.setDialogTitle("Save File");

		// 这里将显示保存文件的对话框
		try {
			flag = fc.showSaveDialog(frm);
		} catch (HeadlessException he) {
			System.out.println("Save File Dialog ERROR!");
		}

		// 如果按下确定按钮，则获得该文件。
		if (flag == JFileChooser.APPROVE_OPTION) {
			// 获得你输入要保存的文件
			f = fc.getSelectedFile();
			// 获得文件名
			fileName = fc.getName(f);
			// 也可以使用fileName=f.getName();
			System.out.println(fileName);
		}
	}

	// 按钮监听器类内部类
	class action implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// 判断是哪个按纽被点击了
			if (e.getSource() == open)
				openFile();
			else if (e.getSource() == read)
				readFile();
		}
	}

	public static void main(String[] args) {
		new FileSearch();
	}
}
