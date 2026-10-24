class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[]months=new int[]{0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String saA[]=arriveAlice.split("-");
        String slA[]=leaveAlice.split("-");
        String saB[]=arriveBob.split("-");
        String slB[]=leaveBob.split("-");
        int[] a1 = new int[saA.length];
        int[] a2 = new int[slA.length];
        int[] b1 = new int[saB.length];
        int[] b2 = new int[slB.length];

        for (int i = 0; i < saA.length; i++) {
            a1[i] = Integer.parseInt(saA[i]);
            a2[i] = Integer.parseInt(slA[i]);
            b1[i] = Integer.parseInt(saB[i]);
            b2[i] = Integer.parseInt(slB[i]);
        }
        /* Non overlapping condition */
        // Alice leaves before Bob arrives
        if ((a2[0] < b1[0]) ||
            (a2[0] == b1[0] && a2[1] < b1[1])) {
            return 0;
        }

        // Bob leaves before Alice arrives
        if ((b2[0] < a1[0]) ||
            (b2[0] == a1[0] && b2[1] < a1[1])) {
            return 0;
        }
        int startMonth, startDay;
        int endMonth, endDay;

        // Maximum arrival date
        if (a1[0] > b1[0] || (a1[0] == b1[0] && a1[1] > b1[1])) {
            startMonth = a1[0];
            startDay = a1[1];
        } else {
            startMonth = b1[0];
            startDay = b1[1];
        }

        // Minimum departure date
        if (a2[0] < b2[0] || (a2[0] == b2[0] && a2[1] < b2[1])) {
            endMonth = a2[0];
            endDay = a2[1];
        } else {
            endMonth = b2[0];
            endDay = b2[1];
        }

        // Convert common arrival to day number
        int start = startDay;
        for (int i = 1; i < startMonth; i++) {
            start += months[i];
        }

        // Convert common departure to day number
        int end = endDay;
        for (int i = 1; i < endMonth; i++) {
            end += months[i];
        }

        return Math.max(0, end - start + 1);

    }
}