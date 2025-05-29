package dev.codecounty.java.java8.core.strings.mutable_builder_buffer;

public class ConcatPerf {
        private static final int ITERATIONS = 100000;
        private static final int BUFFSIZE = 16;

        private void concatStrAdd() {
            System.out.print("concatStrAdd   -> ");
            long startTime = System.currentTimeMillis();
            String concat = new String("");
            for (int i = 0; i < ITERATIONS; i++) {
                concat += i % 10;
            }
            //System.out.println("Content: " + concat);
            long endTime = System.currentTimeMillis();
            System.out.print("length: " + concat.length());
            System.out.println(" time: " + (endTime - startTime));
        }

        private void concatStrBuff() {
            System.out.print("concatStrBuff  -> ");
            long startTime = System.currentTimeMillis();
            StringBuffer concat = new StringBuffer(BUFFSIZE);
            for (int i = 0; i < ITERATIONS; i++) {
                concat.append(i % 10);
            }
            long endTime = System.currentTimeMillis();
            //System.out.println("Content: " + concat);
            System.out.print("length: " + concat.length());
            System.out.println(" time: " + (endTime - startTime));
        }

        private void concatStrBuild() {
            System.out.print("concatStrBuild -> ");
            long startTime = System.currentTimeMillis();
            StringBuilder concat = new StringBuilder(BUFFSIZE);
            for (int i = 0; i < ITERATIONS; i++) {
                concat.append(i % 10);
            }
            long endTime = System.currentTimeMillis();
           // System.out.println("Content: " + concat);
            System.out.print("length: " + concat.length());
            System.out.println(" time: " + (endTime - startTime));
        }

        public static void main(String[] args) {
            ConcatPerf st = new ConcatPerf();
            System.out.println("Iterations: " + ITERATIONS);
            System.out.println("Buffer    : " + BUFFSIZE);

            st.concatStrBuff();
            st.concatStrBuild();
            st.concatStrAdd();
        }
    }