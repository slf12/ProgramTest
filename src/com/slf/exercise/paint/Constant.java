package com.slf.exercise.paint;

import java.awt.Color;

public class Constant {
	public static Color colorArray[] = { Color.white, Color.black, Color.darkGray,
			Color.lightGray, Color.magenta, Color.red, Color.orange,
			Color.yellow, Color.green, Color.blue, };
	
	public static final String[] NAMES = {
	        "New",
	        "Open",
	        "Save", //这三个是基本操作按钮，包括"新建"、"打开"、"保存"
	        /*接下来是我们的画图板上面有的基本的几个绘图单元按钮*/
	      //  "Pencil", //铅笔画，也就是用鼠标拖动着随意绘图
	        "Line", //绘制直线
	        "Rect", //绘制空心矩形
	        "fRect", //绘制以指定颜色填充的实心矩形
	        "Oval", //绘制空心椭圆
	        "fOval", //绘制以指定颜色填充的实心椭圆
	        "Circle", //绘制圆形
	        "fCircle", //绘制以指定颜色填充的实心圆形
	        "RoundRect", //绘制空心圆角矩形
	        "frRect", //绘制以指定颜色填充的实心圆角矩形
	        "Rubber", //橡皮擦，可用来擦去已经绘制好的图案
	        "Color", //选择颜色按钮，可用来选择需要的颜色
	        "Stroke", //选择线条粗细的按钮，输入需要的数值可以实现绘图线条粗细的变化
	        "Word"      //输入文字按钮，可以在绘图板上实现文字输入
	    };
	public static final String[] STYLE_NAMES = {
	        " 宋体 ", " 隶书 ", " 华文彩云 ", " 仿宋_GB2312 ", " 华文行楷 ",
	        " 方正舒体 ", " Times New Roman ", " Serif ", " Monospaced ",
	        " SonsSerif ", " Garamond "
	    };            //可供选择的字体项
	public static final String[] TIP_TEXTS = {
	        //这里是鼠标移动到相应按钮上面上停留时给出的提示说明条
	        //读者可以参照上面的按钮定义对照着理解
	        "Draw a new picture",
	        "Open a saved picture",
	        "Save current drawing",
	        "Draw at will",
	        "Draw a straight line",
	        "Draw a rectangle",
	        "Fill a ractangle",
	        "Draw an oval",
	        "Fill an oval",
	        "Draw a circle",
	        "Fill a circle",
	        "Draw a round rectangle",
	        "Fill a round rectangle",
	        "Erase at will",
	        "Choose current drawing color",
	        "Set current drawing stroke",
	        "Write down what u want"
	    };
	public static int width = 800;
	public static int height = 600;
	public static float stroke = 1.0f;
	public static int currentChoise = 3;
	public static Color color = Color.black;
	public static int R,G,B;
	public static String style;
	public static boolean isSave = false;
}
