/*
# 2217

N(1≤N≤100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다.

각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.

하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.

k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k

만큼의 중량이 걸리게 된다. 각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여

들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오. 모든 로프를 사용해야

할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다. 단, 각각의 로프는

한 개씩만 존재한다.
*/
using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;

public class Lecture 
{
	public static void Main(string[] args) {
        //n개의 로프
        int n = int.Parse(Console.ReadLine());
        int[] ropes = new int[n+1];
        for(int i = 0; i < n; i++){
            ropes[i] = int.Parse(Console.ReadLine());
        }

        var query = from nums in ropes
                    orderby nums descending
                    select nums;

        int mx = 0;
        //현재까지 포함한 로프 개수
        int count = 0;
        foreach(var rp in query){
            count++;
            mx = Math.Max(mx, rp*count);
        }

        Console.WriteLine(mx);
    }
}