package algorithm.SWEA.problems;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합
{
	static int MOD = 1234567891;
	
	static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		while(y > 0) {
			if(y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}
	
	static long nCr(int n, int r, int p) {
		if(r == 0) return 1L;
		
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		return (fac[n] * power(fac[r],p-2,p) % p * power(fac[n-r],p-2,p) % p) % p;
	}
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());
        
        StringTokenizer tokens;
        
        /*
         * 10 * 9 / 2
         * 
         * n! / (r!(n-r)!) 
         * 
         */
        
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(tokens.nextToken());
			int R = Integer.parseInt(tokens.nextToken());
			
			sb.append("#").append(t).append(" ").append(nCr(N,R,MOD)).append("\n");
		}
        
        System.out.println(sb);
    }
}