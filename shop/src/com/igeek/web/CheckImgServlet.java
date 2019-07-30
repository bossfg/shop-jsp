package com.igeek.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ������֤��
 */
public class CheckImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int width = 120;
		int height = 40;
		// �൱��һ�Ż��� �ڴ洴��һ��ͼƬ������
		BufferedImage bufi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// ��ͼƬ��������д����
		// ����
		Graphics g = bufi.getGraphics();

		// ���û��ʵ���ɫ
		g.setColor(Color.WHITE);
		// �޸�ͼƬ�ı�����ɫ
		g.fillRect(0, 0, width, height);

		g.setColor(Color.RED);
		// ���߿�
		g.drawRect(0, 0, width - 1, height - 1);

		String data = "QWERTYUPASDFGHJKLZXCVBNMqwertyupasdfghjkzxcvbnm0123456789";
		int x = 10;
		int y = 30;
		// ����һ�����������
		Random r = new Random();
		
		//����һ��StringBuilder ���û������ͼƬ��д������
		StringBuilder sb = new StringBuilder();
		// ���ɸ�����
		for (int i = 0; i < 8; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width),
					r.nextInt(height));
		}
		//��֤��ͼƬ�е����ֺ���ĸ
		for (int i = 0; i < 4; i++) {

			// ���û��ʵ���ɫ���ò�ͬ������ʾ��ͬ����ɫ
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			// ���������С
			g.setFont(new Font("����", Font.ITALIC, 25));

			int num = r.nextInt(data.length());
			char ch = data.charAt(num);
			sb.append(ch);
			g.drawString( ch+ "", x, y);
			x += 20;
		}
		//��ȡSession,����֤��ͼƬ�ϵ����ݱ�����Session��
		request.getSession().setAttribute("servletImg", sb.toString());
		System.out.println("��������֤�룺:"+sb.toString());
		
		// ��ͼƬ�������е�����д��ҳ��
		ImageIO.write(bufi, "JPG", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
