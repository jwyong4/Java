package com.codestates.seb.electricityBill;

import java.util.Scanner;
public class ElectricityBill {
  public static void main(String[] args) {
    System.out.println("=".repeat(25));
    System.out.println(" 주택용 전기요금(저압) 계산기 ");
    System.out.println("=".repeat(25));

    //TODO:

    // 납부액 계산
    double a, b, c, d, e;
    a = 100 * 60.7;
    b = a + (100 * 125.9);
    c = b + (100 * 187.9);
    d = c + (100 * 280.6);
    e = d + (100 * 417.7);

    // 전기 사용량 input
    System.out.println("전기 사용량을 적어주세요: ");
    Scanner in = new Scanner(System.in);
    double kWh =  in.nextDouble();

    // 전기 요금 계산
    double bill;
    if (kWh <= 100) {                    //100kWh 이하일 때
      bill = kWh * 60.7;
    } else if ( kWh <= 200) {            //100~200kWh 일 때
      bill = ((kWh - 100) * 125.9) + a;
    } else if ( kWh <= 300) {            //200~300kWh 일 때
      bill = ((kWh - 200) * 187.9) + b;
    } else if ( kWh <= 400) {            //300~400kWh 일 때
      bill = ((kWh - 300) * 280.6) + c;
    } else if ( kWh <= 500) {            //400~500kWh 일 때
      bill = ((kWh - 400) * 417.7) + d;
    } else {                             //500kWh< 일 때
      bill = ((kWh - 500) * 670.6) + e;
    }

    System.out.println(kWh + "kWh의 전기 요금은 " + bill + "원 입니다.");

  }
}

// 1, 100 이하인 경우 전력당 60.7 원이 부가됩니다. (사용한 전력 100 kWh 이하일 경)
// 2, 100 이하인 경우 전력당 60.7원 부과, 100 초과인 경우 125.9원 부과 (사용한 전력이 100 kWh 초과일 경우)
//    100kWh 이하는 kWh당 60.7원, 100kWh 초과는 125.9원, 200kWh 초과는 187.9원
//    300kWh 초과는 280.6원, 400kWh 초과는 417.7원, 500kWh 초과는 670.6원