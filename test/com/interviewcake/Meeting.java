package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        return String.format("Meeting(%d, %d)", startTime, endTime);
    }


    public static class MeetingTest{
        /**
         * Your company built an in-house calendar tool called HiCal.
         * You want to add a feature to see the times in a day when everyone is available.
         * To do this, you’ll need to know when any team is having a meeting.
         For example, given:

         [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

         your method would return:

         [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]

         so 0-1
            3-5
            4-8
            9-10
            10-12
         3-5 overlaps with 4-8, hence 3-8 not everyone is available.
         */

        public List<Meeting> determineMeetings(Meeting[] meetings){
            List<Meeting> mergedMeetings = new ArrayList<>();
            Meeting[] sortedMeetings = Arrays.copyOf(meetings, meetings.length);

            Arrays.sort(sortedMeetings, Comparator.comparingInt(o -> o.startTime));


            mergedMeetings.add(new Meeting(sortedMeetings[0].startTime, sortedMeetings[0].endTime));

            for(int i = 1; i < sortedMeetings.length; i++) {
                Meeting lastMeeting = mergedMeetings.get(mergedMeetings.size()-1);
                Meeting current = sortedMeetings[i];
                if(lastMeeting.endTime >= current.startTime){
                    lastMeeting.endTime = Math.max(lastMeeting.endTime, current.endTime);
                }else {
                    mergedMeetings.add(current);
                }
            }

            return mergedMeetings;
        }

        @Test
        public void testMeeting(){
            Meeting[] meetings1 = initMeetings(0,1,3,5,4,8,10,12,9,10,14,15);
            Meeting[] meetings2 = initMeetings(1,3,2,4);
            //print();
            print(determineMeetings(meetings1));
        }

        private void print(List<Meeting> meetings){
            System.out.println(meetings);
        }

        private Meeting[] initMeetings(int... times){
            if(times == null || times.length < 2 || times.length % 2 != 0){
                throw new IllegalArgumentException("Invalid number of times.");
            }
            Meeting[] meetings = new Meeting[times.length/2];
            for(int i = 0; i < times.length/2; i++){
                meetings[i] = new Meeting(times[i*2], times[i*2+1]);
            }
            return meetings;
        }
    }
}
