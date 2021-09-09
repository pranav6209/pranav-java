// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

/*

This problem models rain drops falling on a 1-dimensional sidewalk. Rain drops are given as [center, radius].
Given a [start, end] range on the sidewalk and a series of raindrops that fall, we want to know when the range becomes fully wet.

Input:
double start
double end
List<Drop> = chronologically ordered list [[center1, radius1], [center2, radius2], ......]
Output: the index of the earliest drop after which point the entire range [start, end] is wet

start 0.0
end 1.0
drops [[0.3, 0.2], [0.5, 0.4], [0.5, 0.6]]
return 1

0.0 - 0.1  0.2 0.5

start 0.0
end 1.0
drops [[0.2, 0.2], [0.8, 0.2], [0.5, 0.2]]
return 2


0.0-------------1.0
   -----
           -----
       -----

initial wet areas: []
drop 0 falls: [[0.0, 0.4]]
drop 1 falls: [[0.0, 0.4], [0.6, 1.0]]
drop 2 falls: [[0.0, 1.0]]

initial wet areas: []
drop 0 falls: [[0.0, 0.4]]
drop 1 falls: [[0.0, 0.4], [0.6, 1.0]]
drop 2 [0.3, 0.7]
find [0.0, 0.4]
merge to get [0.0, 0.7]
delete [0.0, 0.4]
wet areas: [[0.6, 1.0]]
find [0.6, 1.0]
merge to get [0.0, 1.0]
delete [0.6, 1.0]
insert [0.0, 1.0]
drop 2 falls: [[0.0, 1.0]]


brute force:

maintain array of [start, end] wet areas
for each drop: // O(n)
    convert to [start, end] interval
    search to discover the intervals that need to be updated // O(n)
    merge into sorted array of intervals // O(n)
    if result covers start and end
        return index

return -1

O(n^2) time
O(n) space

improved brute force:

maintain array of [start, end] wet areas
for each drop: // O(n)
    convert to [start, end] interval
    binary search to discover the intervals that need to be updated // O(log n)
    merge into sorted array of intervals // O(n)
    if result covers start and end
        return index

return -1

optimal:

maintain bst of [start, end] wet areas
for each drop:
    convert to [start, end] interval
    while tree has overlaps:
        find overlap
        merge into current raindrop
        delete overlap
    if merged interval covers start and end:
        return current index
    insert merged interval into wet areas bst

return -1
    
to find an overlap:
    look for the rightmost interval less than the current interval
    if exists and overlaps, return it
    look for the leftmost interval greater than or equal to the current interval
    if exists and overlaps, return it
    if no overlap, return null

*/











class Main {
    /**
     * Given a range defined by [start, end] and a list of chronologically ordered
     * rain drops that fall, finds when the range becomes fully wet.
     * 
     * @param start     the start of the range to check, exclusive.
     * @param end       the end of the range to check, exclusive. Must be larger
     *                  than the start.
     * @param rainDrops given as a center and radius. Each rain drop makes the range
     *                  from [center - radius, center + radius] wet. The radius must
     *                  be positive.
     * @return the index of the earliest rain drop such that the range has become
     *         wet after this drop falls. -1 if no such drop.
     */
    public static int findEarliestWetIndex(double start, double end, Drop[] rainDrops) {
        NavigableSet<Interval> wetIntervals = new TreeSet<Interval>((i1, i2) -> Double.compare(i1.start, i2.start));
        
        for (int i = 0; i < rainDrops.length; ++i) {
            Interval dropInterval = toInterval(rainDrops[i]);
            Interval overlap = findOverlap(wetIntervals, dropInterval);
            Interval merged = new Interval(dropInterval.start, dropInterval.end);
            while (overlap != null) {
                merged.start = Math.min(merged.start, overlap.start);
                merged.end = Math.max(merged.end, overlap.end);
                wetIntervals.remove(overlap);
                overlap = findOverlap(wetIntervals, merged);
            }
            
            if (merged.start <= start && merged.end >= end) {
                return i;
            }

            wetIntervals.add(merged);
        }
        
        return -1;
    }

    private static Interval findOverlap(NavigableSet<Interval> intervals, Interval interval) {
        Interval lower = intervals.floor(interval);
        if (lower != null && lower.end >= interval.start) {
            return lower;
        }
        
        Interval higher = intervals.higher(interval);
        if (higher != null && higher.start <= interval.end) {
            return higher;
        }

        return null;
    }

    private static Interval toInterval(Drop drop) {
        return new Interval(drop.center - drop.radius, drop.center + drop.radius);
    }

}
    private static class Interval {
        public double start;
        public double end;
        
        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Drop {
        public double center;
        public double radius;
        
        public Drop(double center, double radius) {
            this.center = center;
            this.radius = radius;
        }
    }


/* 
Old Content below(Kotlin):

// You should have a top level function called main

fun main(args: Array<String>) {
  println("Hello, World!")
}



Old Content below(Java):

// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

class Main {
    
    
    
    
    
    
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}


 */

    /**
     * Given a range defined by [start, end] and a list of chronologically ordered
     * rain drops that fall, finds when the range becomes fully wet.
     * 
     * @param start     the start of the range to check, exclusive.
     * @param end       the end of the range to check, exclusive. Must be larger
     *                  than the start.
     * @param rainDrops formatted as [center, radius]. Each rain drop makes the
     *                  range from [center - radius, center + radius] wet. The
     *                  radius must be positive.
     * @return the index of the earliest rain drop such that the range has become
     *         wet after this drop falls. -1 if no such drop.
     */
    public static int findIndex2(double start, double end, double[][] rainDrops) {
        List<double[]> intervals = Arrays.stream(rainDrops)
                .map(drop -> new double[] { drop[0] - drop[1], drop[0] + drop[1] }).collect(Collectors.toList());

        int low = 0;
        int high = intervals.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            List<double[]> copy = new ArrayList<>(intervals.subList(0, mid + 1));
            boolean covers = covers(copy, start, end);
            
            if (covers) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    private static boolean covers(List<double[]> intervals, double start, double end) {
        Collections.sort(intervals, (i1, i2) -> Double.compare(i1[0], i2[0]));
        
        double e = start;
        for (double[] interval : intervals) {
            if (interval[0] > e) {
                break;
            }
            
            e = Math.max(e, interval[1]);
        }
        
        return e >= end;
    }
