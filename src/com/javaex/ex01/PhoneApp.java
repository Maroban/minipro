package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		List<Person> pList = new ArrayList<Person>();

		InputStream is = new FileInputStream("E:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		String name, hp, company;

		System.out.println("******************************************************");
		System.out.println("*               전화번호 관리 프로그램               *");
		System.out.println("******************************************************");

		while (true) {
			String data = br.readLine();
			if (data == null) {
				break;
			}
			String[] pArray = data.split(",");

			name = pArray[0];
			hp = pArray[1];
			company = pArray[2];

			Person person = new Person(name, hp, company);

			pList.add(person);
		}

		while (flag) {
			System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료  ");
			System.out.println("------------------------------------------------------");
			System.out.print("> 메뉴 번호: ");
			int menu = sc.nextInt();
			int num = 1;

			switch (menu) {
			case 1:

				System.out.println("<1. 리스트>");

				for (Person person : pList) {
					System.out.println(num + person.showInfo());
					num++;
				}

				System.out.println();
				break;

			case 2:
				System.out.println("<2. 등록>");
				sc.nextLine();
				System.out.print("이름: ");
				name = sc.nextLine();

				System.out.print("전화번호: ");
				hp = sc.nextLine();

				System.out.print("회사번호: ");
				company = sc.nextLine();

				Person person01 = new Person(name, hp, company);
				pList.add(person01);

				System.out.println("[등록되었습니다.]");
				System.out.println();
				break;

			case 3:
				System.out.println("<3. 삭제>");
				System.out.print("> 번호: ");
				int number = sc.nextInt();
				pList.remove(--number);
				System.out.println("[삭제되었습니다.]");
				System.out.println();
				break;

			case 4:
				sc.nextLine();
				System.out.println("<4. 검색>");
				System.out.print("> 이름: ");
				String s = sc.nextLine();

				for (Person p : pList) {
					if (p.getName().contains(s)) {
						System.out.println(num + p.showInfo());
					}
				}
				break;

			case 5:
				System.out.println();
				System.out.println("*******************************************************");
				System.out.println("*                     감사합니다.                     *");
				System.out.println("*******************************************************");

				OutputStream os = new FileOutputStream("E:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);

				for (Person p : pList) {
					bw.write(p.getName() + "," + p.getHp() + "," + p.getCompany());
					bw.newLine();
				}

				flag = false;

				bw.close();
				break;

			default:
				System.out.println("[다시 입력해 주세요]");
				break;
			}
		}

		sc.close();
		br.close();

	}

}
