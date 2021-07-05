import java.util.*;
import java.io.*;

class Sort{
	static int[] b;
	static void swap(int[] a, int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	void countingSort(int[] a){
		int[] count=new int[100000000];
		int n=a.length;
		for(int i=0;i<n;i++) count[a[i]]++;
		for(int i=1;i<count.length;i++) count[i]+=count[i-1];
		int[] ans=new int[n];
		for(int i=n-1;i>=0;i--){
			ans[--count[a[i]]]=a[i];
		}
		for(int i=0;i<n;i++) a[i]=ans[i];
	}
	void selectionSort(int[] a){
		int n=a.length;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(a[j]<a[i])
					swap(a, i, j);
			}
		}
	}
	void bubbleSort(int[] a){
		int n=a.length;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1-i;j++){
				if(a[j]>a[j+1])
					swap(a, j, j+1);
			}
		}
	}
	void insertionSort(int[] a){
		int n=a.length;
		for(int i=1;i<n;i++){
			int temp=a[i];
			int j=i-1;
			while(j>=0 && a[j]>temp){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
	}
	void mergeSort(int[] a,int l,int r){
		b=new int[a.length];
		int mid=(l+r)/2;
		if(l<r){
			mergeSort(a, l, mid);
			mergeSort(a, mid+1, r);
			merge(a, l, mid, r);
		}
	}
	static void merge(int[] a, int l, int mid, int r){
		int i=l, j=l, k=mid+1;
		while(j<=mid && k<=r){
			if(a[j]<a[k]) b[i++]=a[j++];
			else b[i++]=a[k++];
		}
		while(j<=mid) b[i++]=a[j++];
		while(k<=r) b[i++]=a[k++];
		for(int z=l;z<=r;z++) a[z]=b[z];
	}
	void quickSort(int[] a, int lb, int ub){
		if(lb<ub){
			int pivot=partition(a, lb, ub);
			quickSort(a, lb, pivot-1);
			quickSort(a, pivot+1, ub);
		}

	}
	static int partition(int[] a, int lb, int ub){
		int pivot=lb;
		int start=lb, end=ub;
		while( start<end){
			while(start<ub && a[start]<a[pivot]) start++;
			while(end>lb && a[end]>=a[pivot]) end--;
			if(end>start)
				swap(a, start, end);
		}
		swap(a, lb, end);
		return end;
	}
	void radixSort(int[] a){
		int max=0, n=a.length;
		for(int i=0;i<n;i++) max=Math.max(max, a[i]);
		int cnt=0;
		while(max>0){cnt++; max/=10;}
		for(int i=0;i<cnt;i++){
			int[] count=new int[10];
			int[] temp=new int[n];
			for(int j=0;j<n;j++){
				count[(a[j]/(int)Math.pow(10, i))%10]++;
			}
			for(int j=1;j<10;j++) count[j]+=count[j-1];
			for(int j=n-1;j>=0;j--){
				temp[--count[(a[j]/(int)Math.pow(10, i))%10]]=a[j];
			}
			for(int j=0;j<n;j++) a[j]=temp[j];
		}
	}
	void bucketSort(int[] a){
		
	}


} 

class Solution{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Sort sort=new Sort();
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) a[i]=sc.nextInt();
		System.out.println("Sorting in progress...");
		sort.radixSort(a);
		for(Integer x: a) System.out.print(x+" ");
		System.out.println();
		System.out.println("Sorting Done!");
		
	}
	
}