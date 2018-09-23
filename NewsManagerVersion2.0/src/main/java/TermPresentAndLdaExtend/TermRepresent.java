package TermPresentAndLdaExtend;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
/*
 * ��һ����չLDA�Ѿ���ɣ���LDA���ɵģ�DF��û�е������ʣ���������HashMap�У���һ������ʺ���ţ��ڶ�������ʺͶ�Ӧ�ĸ��ʣ��ӵ�����
 * ��һ����DF�����ݹ�һ��
 * ��һ����LDA����ʺ���Ӧ����
 * 
 */
//��ģ��Ĺ����ǽ�Ԥ������ѵ������������ı��������������ʵ䣬ʹ��tf*idf�㷨���ı�����������ʾ
public class TermRepresent {
	//private String inputTextFile;//��������ı����ļ�
	//private String inputTermDic;//�����ʵ��ļ�
	//private static String outputTermRepresent;//�ı�����������ʾ�ļ�
	
	private static String[] docs;//������ı���
	private static String[] terms;//����������ʵ�
	private int numDocs=0;//������ı������ı���
	private int numTerms=0;//����������ʵ�������ʸ���
	private int[][] termFreq;
	private float[][] termWeight;
	private int[] maxTermFreq;
	private int[] docFreq;
	float Max=0;
	float Min=0;
	
	
	private Dictionary wordsIndex=new Hashtable();//����ʹ�õ������ʵ�
	private String[] trDocs;//�ı�����������ʾ��
	private HashMap<String, Integer> num =new HashMap<String, Integer>();
	private HashMap<String, Float> nums;
	private HashMap<String, Float> copy;
	//2���������ʵ���ı�������������ʾ������һ��String[]��	
	//��������˴�����   num ��     nums
	public String[] TermRepresentMain(String[] allDocs,String[] termDic){
		docs=allDocs;
		terms=termDic;
		numDocs=docs.length;
		numTerms=terms.length;
		maxTermFreq=new int[numDocs] ;
		docFreq=new int[numTerms] ;
		termFreq =new int[numTerms][] ;
//////////////����HashMap////////////////////////////////////////////////////////////////
		try {
			nums=new LdaWords().getMap();
			copy =new HashMap<String, Float>(nums);
//			check(nums, termDic);
			int add =numTerms;
			////////////////////////��ʼ��NUM
			for(String s:nums.keySet()){
				num.put(s, add);
				add++;
				System.out.println(s+" "+add);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		num.put("����", numTerms);
//		nums.put("����", (float) 0.056879);
//		num.put("����2", numTerms+1);
//		nums.put("����2", (float) 0.054718);
///////////////////////////////////////////////////////////////////////
		termWeight=new float[numTerms+num.size()][numDocs] ;
		//����Ҫ����termWeigh������////////////////////////////////////////////////////////////
		//2.1�����е������ʼ��뵽Hashtable��
		for(int i=0; i < terms.length ; i++)			
		{
//			termWeight[i]=new float[numDocs] ;
			termFreq[i]=new int[numDocs] ;

			AddElement(wordsIndex, terms[i], i);			
		}
	//����LDA ������ ��������//////////////////////////////////////////////////////////////////
		for(int j=0;j<docs.length;j++)
		{
			putLdaWords(num, j, nums);
		}
	//����LDA ������ ��������////////////////////////////////////////////////////////////////////
		//2.2����tf (��������ĳ���ĵ��г��ֵĴ���)
		GenerateTermFrequency();
		//2.3����weight,������ڶ�ά������		
		GenerateTermWeight();
		/*
		//����ά�����ʾתΪKNN��Ҫ��ĸ�ʽ
		System.out.println(termWeight.length);
		System.out.println(termWeight[0].length);
		String[] result=new String[docs.length];
		for(int i=0; i<termWeight[0].length;i++)
		{
			result[i]=docs[i].substring(0, 1);
			for(int j=0;j<termWeight.length;j++)
			{
				//if(termWeight[j][i]!=0)
					result[i]+=" "+termWeight[j][i];
			}
		}
		System.out.println(result.length);
		*/
		//����ά�����ʾתΪlibsvm��Ҫ��ĸ�ʽ
		//��һ//////////////////////////////////////////////////
		normalization();
		System.out.println(termWeight.length);
		System.out.println(termWeight[0].length);
//		checkfirst(copy, termDic);
		String[] result=new String[docs.length];
		for(int i=0; i<termWeight[0].length;i++)
		{
			result[i]=docs[i].substring(0, 1);
			for(int j=0;j<terms.length;j++)
			{
				//J��������  i���ĵ������еĴ�(ÿһ��)
				if(termWeight[j][i]!=0)
					result[i]+=" "+j+":"+termWeight[j][i];
			}
		}
///////�������������ѵ��//////////////////////////////////////////////////////////////////
		for(int i=0; i<termWeight[0].length;i++){
			for(int j=terms.length;j<termWeight.length;j++){
				if(termWeight[j][i]!=0)
				result[i]+=" "+(j+1)+":"+0.5;
			}
		}
///////////////////////////////////////////////////////////////////////////
		System.out.println(result.length);
		
		//String[] result=new String[docs.length];
		
		return result; 
	}
	
	//2.1��ȫ�������ʷ��뵽Hashtable��
	private static Object AddElement(Dictionary collection, Object key, Object newValue)
	{
		Object element=collection.get(key);
		collection.put(key, newValue);
		return element;
	}
	
	//2.2����tf (��������ĳ���ĵ��г��ֵĴ���)
	private void GenerateTermFrequency()
	{
		for(int i=0; i < numDocs  ; i++)
		{								
			String curDoc=docs[i];
			Dictionary freq=GetWordFrequency(curDoc);
			Enumeration enums=freq.keys();
			
			while(enums.hasMoreElements()){
				String word=(String) enums.nextElement();
				int wordFreq=(Integer)freq.get(word);
				int termIndex=GetTermIndex(word);
                if(termIndex == -1)
                    continue;
				termFreq [termIndex][i]=wordFreq;
				docFreq[termIndex] ++;

				if (wordFreq > maxTermFreq[i]) maxTermFreq[i]=wordFreq;	
			}			
			maxTermFreq[i]=Integer.MIN_VALUE ;
		}
	}
	private Dictionary GetWordFrequency(String input)
	{
		String convertedInput=input.toLowerCase() ;	       
        String r="([|])";//ÿ�д�����ĵ�ԭʼ��ʽ�ǣ����|��1|��2|...
        String[] words = convertedInput.split(r);
		Arrays.sort(words);
		
		String[] distinctWords=GetDistinctWords(words);
					
		Dictionary result=new Hashtable();
		for (int i=0; i < distinctWords.length; i++)
		{
			Object tmp;
			tmp=CountWords(distinctWords[i], words);
			result.put(distinctWords[i], tmp);
			
		}
		
		return result;
	}
	private static String[] GetDistinctWords(String[] input)
	{				
		if (input == null)			
			return new String[0];			
		else
		{
            List<String> list = new ArrayList<String>();
			
			for (int i=0; i < input.length; i++)
				if (!list.contains(input[i])) 			
					list.add(input[i]);
			String[] v=new String[list.size()];
			return (String[]) list.toArray(v);
		}
	}
	private int CountWords(String word, String[] words)
	{
		int itemIdx=Arrays.binarySearch(words, word);
		
		if (itemIdx > 0)			
			while (itemIdx > 0 && words[itemIdx].equals(word))				
				itemIdx--;				
					
		int count=0;
		while (itemIdx < words.length && itemIdx >= 0)
		{
			if (words[itemIdx].equals(word)) count++;				
			
			itemIdx++;
			if (itemIdx < words.length)				
				if (!words[itemIdx].equals(word)) break;					
			
		}
		
		return count;
	}
	private int GetTermIndex(String term)
	{
		Object index=wordsIndex.get(term);
		if (index == null) return -1;
		return (Integer)index;
	}
	//2.3����weight
	private void GenerateTermWeight()
	{			
		for(int i=0; i < numTerms   ; i++)
		{
			for(int j=0; j < numDocs ; j++)	{			
				termWeight[i][j]=ComputeTermWeight (i, j);		
		//��������ж���0������ѡ��Ĵ���DF��û�г��֣��ж��Ƿ������LDAģ���У�������֣��ӽ�ȥ������
//			   if(termWeight[i][j]==0){
//				   putLdaWords(i,j);
//			   }
			}
		}
	}
//�ؼ����ɨ��ÿһ�У�������֣���������ֵ///////////////////////////////////////////////////////////////////////////////
	private void putLdaWords(HashMap<String, Integer> num,int j,HashMap<String, Float> nums){
		String flag=docs[j];
		Set<String> set =  nums.keySet();
		String mid[] = flag.split("\\|");
		for(int k=0;k<mid.length;k++){
	
			if(set.contains(mid[k])){
				termWeight[num.get(mid[k])][j]=nums.get(mid[k]);
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////
	private float ComputeTermWeight(int term, int doc)
	{
		float tf=GetTermFrequency (term, doc);
		float idf=GetInverseDocumentFrequency(term);
		return tf * idf;
	}
	private float GetTermFrequency(int term, int doc)
	{			
		int freq=termFreq [term][doc];
		int maxfreq=maxTermFreq[doc];			
		
		return ( (float) freq/(float)maxfreq );
	}
	private float GetInverseDocumentFrequency(int term)
	{
		int df=docFreq[term];
		//20110509���
		if (df==0)
			return 0;
		else
		//20110509���
		return Log((float) (numDocs) / (float) df );
	}
	private float Log(float num)
	{
		return (float) Math.log(num) ;//log2
	}
/////////////////////////////////////��һ��/////////
	private void normalization(){
		//�ҳ������Сֵ
		for(int i=0;i<terms.length;i++){
		   for(int j=0;j<termWeight[0].length;j++){
                 Max =Math.max(Max, termWeight[i][j]);
                 Min =Math.min(Min, termWeight[i][j]);
		   }
		}
		float mid =Max-Min;
	//��һ
		for(int i=0;i<terms.length;i++){
			   for(int j=0;j<termWeight[0].length;j++){
				   if(termWeight[i][j]!=0){
					   termWeight[i][j]=(termWeight[i][j]-Min)/mid;
				   }
			   }
			}
	}
////////////////////////////////////////////////////
	
//LDAȥ��///////////////////////////////////////
	private void check(HashMap<String, Float> map,String[] termsDic) {
		List<String> list =	Arrays.asList(termsDic);
        Iterator<Entry<String, Float>> it3 = map.entrySet().iterator();
        while(it3.hasNext()){
            Entry<String, Float> entry = it3.next();
            if(list.contains(entry.getKey())||entry.getValue()==0){
            	it3.remove();
            };
        }
	}
	//��ǿ///////////////////////////////////////////////////
	private void checkfirst(HashMap<String, Float> map,String[] termsDic) {
		Set<String> set =map.keySet();
		for(int i=0;i<termsDic.length;i++){
			if(set.contains(termsDic[i])){
				for(int m=0;m<termWeight[i].length;m++){
					if(termWeight[i][m]!=0)
						//��һ�����ܸģ��ı���ʾ��Ͳ�����Ȩ��
					termWeight[i][m]=(float) (0.8);
				}
			}
		}
	}
}
