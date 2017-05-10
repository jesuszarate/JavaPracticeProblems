package ModerateCCI;


/**
 *
 *
 * Created by jesuszarate on 5/17/17.
 */
public class SubSort {

    public static void main (String[] a){
        int[] lst = {1, 2, 4, 10, 3, 5, 16, 18, 19};

        lst = SubSort(lst);
        System.out.println(lst[0] + ", " + lst[1]);

        lst = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        lst = SubSort(lst);
        System.out.println(lst[0] + ", " + lst[1]);

        lst = new int[]{1, 2, 3, 4, 5, 6};
        lst = SubSort(lst);
        System.out.println(lst[0] + ", " + lst[1]);

        lst = new int[]{2, 3, 5, 1};
        lst = SubSort(lst);
        System.out.println(lst[0] + ", " + lst[1]);
    }

    static int[] SubSort(int[] lst){
        int un = findUnordered(lst);
        if (un == lst.length) return new int[]{un,un};

        swap(lst, un, un+1);
        return new int[]{LSubSort(lst, un, un), HSubSort(lst, un+1, un+1)};
    }

    static int LSubSort(int[] lst, int L, int maxL){
        if (L == 0) return maxL;

        if(lst[L] < lst[L - 1]) {
            swap(lst, L, L - 1);
            maxL = L;
        }

        return LSubSort(lst, L - 1, maxL);
    }

    static int HSubSort(int[] lst, int H, int maxH){
        if (H == lst.length - 1) return maxH;

        if(lst[H] > lst[H + 1]) {
            maxH = H + 1;
            swap(lst, H, H + 1);
        }

        return HSubSort(lst, H + 1, maxH);
    }

    private static void swap(int[] lst, int i, int j) {
        int temp = lst[i];
        lst[i] = lst[j];
        lst[j] = temp;
    }

    static int findUnordered(int[] lst){
        for (int i = 0; i < lst.length - 1; i++){
           if(lst[i] > lst[i+1]) return i;
        }
        return lst.length;
    }
}
