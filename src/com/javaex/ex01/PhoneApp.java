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

		// PhoneDB.txt 읽기
		InputStream is = new FileInputStream("E:\\javaStudy\\workspace\\minipro\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 스캐너
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		String name, hp, company;

		System.out.println("******************************************************");
		System.out.println("*               전화번호 관리 프로그램               *");
		System.out.println("******************************************************");

		// PhoneDB.txt 읽은 후 리스트에 add
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

		while (flag) { // 메뉴 출력
			System.out.println("1. 리스트  2. 등록  3. 삭제  4. 검색  5. 종료  ");
			System.out.println("------------------------------------------------------");
			System.out.print("> 메뉴 번호: ");
			int menu = sc.nextInt();
			int num = 1;

			switch (menu) {

			// 리스트 출력
			case 1:
				System.out.println("<1. 리스트>");

				for (Person person : pList) {
					System.out.println(num + person.showInfo());
					num++;
				}

				System.out.println();
				break;

			// 연락처 등록
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

			// 연락처 삭제
			case 3:
				System.out.println("<3. 삭제>");
				System.out.print("> 번호: ");
				int number = sc.nextInt();
				pList.remove(--number);
				System.out.println("[삭제되었습니다.]");
				System.out.println();
				break;

			// 연락처 검색
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

			// 종료
			case 5:
				System.out.println();
				System.out.println("*******************************************************");
				System.out.println("*                     감사합니다.                     *");
				System.out.println("*******************************************************");

				// 리스트에 저장된 값을 PhoneDB.txt에 쓰기
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

			// 없는 메뉴 출력
			default:
				System.out.println("[다시 입력해 주세요]");
				break;
			}
		}

		sc.close();
		br.close();

	}

}
