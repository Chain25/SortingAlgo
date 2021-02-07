package com.georgian;

import java.util.Scanner;

public class AllSortAlgo {
	
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		//int[] arr = { 23,24,-56,1,7,2};
		System.out.println("Enter size of array:");
		int size=scanner.nextInt();
		int[] array = new int[size];
		System.out.println("enter element:");
		
		for(int i=0;i<size;i++) {
			array[i] = scanner.nextInt();
		}
		int low=0;
		int high=array.length-1;
		Menu(); // function for menu for selecting sort algo
		int option = scanner.nextInt();
		switch(option) {
			case 1:
				System.out.println("before sorting");
				
				printArray(array);
				bubbleSort(array,size);
				break;
			case 2:
				insertionSort(array,size);
				
				break;
			case 3: 
				break;
			case 4:
				
				
				merge_Sort(array,low,high);
				printArray(array);
				 break;
			case 5:
				System.out.println("0 - Pivot as first element for quick sort");
				System.out.println("1 - pivot as last element for quick sort");
				
				int option1=scanner.nextInt();
				switch(option1) {
				case 0:
					quickSortFirst(array,low,high);
					printArray(array);
					
					break;
				case 1:
					quickSort(array,low,high);
					printArray(array);
					break;
				}
				
					break;
				default:
					
		}
		
	}

	private static void quickSortFirst(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		if(low<high) {
			int pivot = partitionFirst(array,low,high);
			quickSort(array,low,pivot-1);
			quickSort(array,pivot+1,high);
		}
		
	}

	private static int partitionFirst(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int i=high+1;
		int j=high;
		int pivot=array[low];
		for(;j>low;j--) {
			
			if(array[j]>pivot) {
				i--;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
	}
		}
		i--;
		array[i]=array[i]+array[low];
		array[low]=array[i]-array[low];
		array[i]=array[i]-array[low];
		return i;
	}

	private static void quickSort(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		
		if(low<high) {
			int pivot = partition(array,low,high);
			quickSort(array,low,pivot-1);
			quickSort(array,pivot+1,high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int j=low;
		int i=j-1;
		int pivot=array[high];
		while(j<high) {
			if(array[j]<pivot) {
				i++;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				
				
			}
			j++;
		}
		i++;
		int temp=array[i];
		array[i]=array[high];
		array[high]=temp;
		//swap(array[i],array[high]);
		
return i;
		
		
	}

	

	private static void merge_Sort(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int mid;
		if(low<high) {
			mid=(low+high)/2;
			merge_Sort(array,low,mid);
			merge_Sort(array,mid+1,high);
			merge(array,low,mid,high);
		}
		
	}

	private static void merge(int[] array, int low, int mid, int high) {
		// TODO Auto-generated method stub
		
		int LSize=mid - low +1; // +1 becoz array start from 0 index
		int RSize= high - mid;
		int[] LArray=new int[LSize];
		int[] RArray= new int[RSize];
		
		for(int i=0;i<LSize;i++) {
			LArray[i] = array[low+i];
		}
		//int index=0;
		for(int i=0;i<RSize;i++) {
			
			RArray[i] = array[mid+1+i];
			
		}
		
		
		int i=0,j=0;
		while(i<LSize&&j<RSize) {
			if(LArray[i]<RArray[j]) {
				array[low]=LArray[i];
				i++;
				
			}else {
				array[low]=RArray[j];
				j++;
				
			}
			low++;
		}
		while(i<LSize) {
			array[low]=LArray[i];
			low++;
			i++;
		}
		
		while(j<RSize) {
			array[low]=RArray[j];
			low++;
			j++;
		}
		
//		System.out.println("value after merge function ");
//		for(int i1=0;i1<=high;i1++) {
//			System.out.print(array[i1]+"\t");
//		}
//		System.out.println("\n");
		
		
		
	}

	private static void insertionSort(int[] array, int size) {
		// TODO Auto-generated method stub
		for(int i=1;i<size;i++) {
			int key=array[i];
			int j;
			for(j=i;j>0;j--) {
				if(key < array[j-1]) {
					array[j]=array[j-1];
				}
			}
			array[j]=key;
		}
		System.out.println("after sorting");
		printArray(array);
		
	}

	private static void Menu() {
		// TODO Auto-generated method stub
		
		System.out.println("Pick one opion for sorting array: \n"
				+ "1: bubblesort\n"
				+ "2: insertionsort\n"
				+ "3: selection sort\n"
				+ "4: merge sort\n"
				+ "5: quick sort");
		
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i =0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

	private static void bubbleSort(int[] a, int length) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<length;i++) {
			
			for(int j=i+1;j<length;j++) {
				if(a[i]>a[j]) {
					//swap
					a[i] = a[i]+a[j];
					a[j] = a[i]-a[j];
					a[i] = a[i]-a[j];
					
				}
				printArray(a);
				System.out.println("\n");
			}
		}
		System.out.println("After sorting");
		printArray(a);
		
	}
	
}
