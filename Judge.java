//Shashank Eeda
public class Judge {
    /*
    The method is meant to find out who is the judge
     */
    public int findJudge (int N, int [][] trust){
        //Following 4 if statements are incase the list is empty
        if(trust.length<=0&&N==1)
            return 1;
        if(trust.length<=0&&N>=2)
            return -1;
        if(trust[0].length==0&&N==1&&trust.length==1)
            return 1;
        if(trust[0].length==0&&N>=2&&trust.length==1)
            return -1;
        int count=0;
        int t=0;
        boolean truth=true;
        /*
        Placing every set of coordinates into boolean variable bool,
         */
        boolean[][] bool=new boolean[N+1][N+1];
        //Initially everything in bool is set to false
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                bool[i][j]=false;
            }
        }
        /*
        This loops through the 2D array trust and sets the
        the coordinates provided from false to true by
        using bool[trust[i][0]][trust[i][1]]=true;
        and we're not using indexes but the values
         */
        for(int i=0;i<trust.length;i++){
                bool[trust[i][0]][trust[i][1]]=true;
        }
        /*
        This double forloop is meant to check if a number is in every
        2nd column with every other number in the first column and if that
        is true it makes sure if that number is not in the first column
        anywhere, if it is then it is false, otherwise we just return true
         */
        for(int i=1;i<=N;i++){
            count=0;
            t=i;
            for(int j=1;j<=N;j++){
                if(bool[j][i]==true) {
                    count++;
                    continue;
                }
            }
            /*
            If count>=N-1 then it meets the criteria
            of a judge and then so we check the first
            column of trust in every pair to make sure
            it is not located there, return the value if it
            isn't there
             */
            if(count>=N-1) {
                for(int w=0;w<trust.length;w++){
                    if(trust[w][0]==t) {
                        truth = false;
                        break;
                    }
                }
                if(truth)
                    return t;
            }
        }
        //returns -1 if there is no judge
        return -1;
    }
    public static void main(String[] args){
        /*
        Following lines below are meant to be used to test different inputs and outputs.
         */
        Judge j=new Judge();
        int [][] arr={{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(j.findJudge(4,arr));
    }
    //{{1, 3}, {2, 3}, {3, 1}};
    //{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}
    //{{1, 2}, {2, 3}}
    //{{1, 3}, {2, 3}}
    //{{1, 2}}
}
