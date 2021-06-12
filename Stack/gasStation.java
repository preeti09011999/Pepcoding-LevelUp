class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int deficit = 0, extragas = 0, sp = 0;
        for(int i=0;i<gas.length;i++){
            extragas += gas[i] - cost[i];
            if(extragas < 0){
                deficit += extragas;
                extragas = 0;
                sp = i + 1;
            }
        }
        return (sp == gas.length || deficit + extragas < 0) ? -1 : sp;
    }
}
