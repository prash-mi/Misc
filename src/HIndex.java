public class HIndex {
public static void main(String[] args){
    int[] ip1 = {0,1,3,5,6};
    int[] ip2 = {100};
    int[] ip3 = {0,1};
    int[] ip4 = {0};
    int[] ip5 = {1,1};

    System.out.println(new HIndex().hIndex(ip1));
    System.out.println(new HIndex().hIndex(ip2));
    System.out.println(new HIndex().hIndex(ip3));
    System.out.println(new HIndex().hIndex(ip4));
    System.out.println(new HIndex().hIndex(ip5));
    /*
    OP:
    3
    1
    1
     */

}

    public int hIndex(int[] citations) {
        return hIndexBinary(citations, 0, citations.length-1);
    }
    public static int hIndexBinary(int[] citations, int left, int right) {

    if (citations == null || citations.length <1){
        return 0;
    }

    if(right < left){
        return 0;
    }

    int mid = (left+right)/2;
    int h = citations.length-mid;
    if(citations[mid] >= h){
            if(mid == 0){
                return h;
            }

            if(citations[mid-1] >= h+1){//go left
                return hIndexBinary(citations, left, mid-1);
            }else if (citations[mid-1] < h+1){
                return h;
            }
        }else{//go right
            return hIndexBinary(citations, mid+1, right);
    }
    return 0;
    }



    public int hIndexLinear(int[] citations) {//linear time complexity
        int h = 0;
        for(int i = 0; i < citations.length; i++){
            h = citations.length - i;
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }

}


