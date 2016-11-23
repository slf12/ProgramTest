package com.slf.exercise.paint;

import java.awt.Color;

public class Constant {
	public static Color colorArray[] = { Color.white, Color.black, Color.darkGray,
			Color.lightGray, Color.magenta, Color.red, Color.orange,
			Color.yellow, Color.green, Color.blue, };
	
	public static final String[] NAMES = {
	        "New",
	        "Open",
	        "Save", //�������ǻ���������ť������"�½�"��"��"��"����"
	        /*�����������ǵĻ�ͼ�������еĻ����ļ�����ͼ��Ԫ��ť*/
	      //  "Pencil", //Ǧ�ʻ���Ҳ����������϶��������ͼ
	        "Line", //����ֱ��
	        "Rect", //���ƿ��ľ���
	        "fRect", //������ָ����ɫ����ʵ�ľ���
	        "Oval", //���ƿ�����Բ
	        "fOval", //������ָ����ɫ����ʵ����Բ
	        "Circle", //����Բ��
	        "fCircle", //������ָ����ɫ����ʵ��Բ��
	        "RoundRect", //���ƿ���Բ�Ǿ���
	        "frRect", //������ָ����ɫ����ʵ��Բ�Ǿ���
	        "Rubber", //��Ƥ������������ȥ�Ѿ����ƺõ�ͼ��
	        "Color", //ѡ����ɫ��ť��������ѡ����Ҫ����ɫ
	        "Stroke", //ѡ��������ϸ�İ�ť��������Ҫ����ֵ����ʵ�ֻ�ͼ������ϸ�ı仯
	        "Word"      //�������ְ�ť�������ڻ�ͼ����ʵ����������
	    };
	public static final String[] STYLE_NAMES = {
	        " ���� ", " ���� ", " ���Ĳ��� ", " ����_GB2312 ", " �����п� ",
	        " �������� ", " Times New Roman ", " Serif ", " Monospaced ",
	        " SonsSerif ", " Garamond "
	    };            //�ɹ�ѡ���������
	public static final String[] TIP_TEXTS = {
	        //����������ƶ�����Ӧ��ť������ͣ��ʱ��������ʾ˵����
	        //���߿��Բ�������İ�ť������������
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
