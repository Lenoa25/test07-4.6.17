package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Main {

    public static void main(String[] args) {


        File file1, file3, file2;
        file1 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\noalehrer\\MyFile1.txt");
        file2 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\noalehrer\\MyFile2.txt");
        file3 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\noalehrer\\MyFile3.txt");
        OutputStream outputStream1 = null, outputStream2 = null;
        int num;
        try {
            outputStream1 = new FileOutputStream(file1);
            outputStream2 = new FileOutputStream(file2);
            byte[] aBytes = new byte[4];
            for (int i = 0; i < 20; i++) {
                ByteBuffer.wrap(aBytes).putInt(i);
                if (i % 2 == 0) {
                    for (int j = 0; j < 4; j++) {
                        outputStream1.write(aBytes[j]);
                    }
                } else {
                    for (int j = 0; j < 4; j++) {
                        outputStream2.write(aBytes[j]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream1 != null)
                try {
                    outputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outputStream2 != null)
                try {
                    outputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        mergeFile(file1, file2, file3);

        InputStream inputStream1 = null;
        try {
            inputStream1 = new FileInputStream(file3);
            byte[] buffer1 = new byte[4];
            int actuallyRead1;
            while ((actuallyRead1 = inputStream1.read(buffer1)) != -1) {
                System.out.println(ByteBuffer.wrap(buffer1).getInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-------------------------------------------------------------------------

        int[] ints = returnKarr(file3, 4);

        for (int i = 0; i < 4; i++) {
            System.out.print(ints[i] + ", ");
        }

        //-------------------------------------------------------------------------


        File file = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\noalehrer\\MyFile5.txt");
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            outputStream.write("good ABC good try in out in in good good".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        Map<String, Integer> map = statisticalInformation(file);
        System.out.println();
        System.out.println(map.size());

        //-----------------------------------------------------------------------------

     //   System.out.println(randomInt(file3));


    }


    public static void mergeFile(File file1, File file2, File file3) {
        InputStream inputStream1 = null, inputStream2 = null;
        OutputStream outputStream = null;
        try {
            inputStream1 = new FileInputStream(file1);
            inputStream2 = new FileInputStream(file2);
            outputStream = new FileOutputStream(file3);
            byte[] buffer1 = new byte[4];
            byte[] buffer2 = new byte[4];
            byte[] aBytes = new byte[4];
            int actuallyRead1, actuallyRead2;
            int a = 0, b = 0, ezer = 0;
            actuallyRead1 = inputStream1.read(buffer1);
            actuallyRead2 = inputStream2.read(buffer2);
            if (actuallyRead1 != -1)
                a = ByteBuffer.wrap(buffer1).getInt();
            if (actuallyRead2 != -1)
                b = ByteBuffer.wrap(buffer2).getInt();

            while ((actuallyRead1 != -1) && (actuallyRead2 != -1)) {
                if (a < b) {
                    while (a < b && (actuallyRead1 = inputStream1.read(buffer1)) != -1) {
                        ByteBuffer.wrap(aBytes).putInt(a);
                        for (int j = 0; j < 4; j++) {
                            outputStream.write(aBytes[j]);
                        }
                        a = ByteBuffer.wrap(buffer1).getInt();
                    }
                } else {
                    while (b < a && (actuallyRead2 = inputStream2.read(buffer2)) != -1) {
                        ByteBuffer.wrap(aBytes).putInt(b);
                        for (int j = 0; j < 4; j++) {
                            outputStream.write(aBytes[j]);
                        }
                        b = ByteBuffer.wrap(buffer2).getInt();
                    }
                }

            }

            if (b < a) {
                ezer = b;
                b = a;
                a = ezer;
            }
            ByteBuffer.wrap(aBytes).putInt(a);
            for (int j = 0; j < 4; j++) {
                outputStream.write(aBytes[j]);
            }
            ByteBuffer.wrap(aBytes).putInt(b);
            for (int j = 0; j < 4; j++) {
                outputStream.write(aBytes[j]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream1 != null)
                try {
                    inputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (inputStream2 != null)
                try {
                    inputStream2.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }

    //-----------------------------------------------------------
    public static int[] returnKarr(File file, int k) {
        int[] arrK = new int[k];
        for (int i = 0; i < k; i++) {
            arrK[i] = Integer.MAX_VALUE;
        }
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue(arrK);

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[4];
            int actuallyRead;
            int num;
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                num = ByteBuffer.wrap(buffer).getInt();
                if (num < myPriorityQueue.getMax()) {
                    myPriorityQueue.extractMax();
                    myPriorityQueue.insert(num);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return arrK;
    }

    //----------------------------------------------------------------------------
    public static Map statisticalInformation(File file) {
        Map<String, Integer> map = new HashMap<>();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);

            char[] chars = new char[50];
            int actuallyRead, wordLength = 0;
            String s;
            while ((actuallyRead = inputStream.read()) != -1) {
                byte b = (byte) actuallyRead;
                char c = (char) b;
                if (c == ' ') {
                    s = new String(chars, 0, wordLength);
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        Integer integer = map.get(s);
                        integer++;
                        map.replace(s, integer);
                    }

                    wordLength = 0;
                } else {
                    chars[wordLength] = c;
                    wordLength++;
                }
            }

            s = new String(chars, 0, wordLength);
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                Integer integer = map.get(s);
                integer++;
                map.replace(s, integer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return map;
    }

    //--------------------------------------------------------------------------------------

    public static int randomInt(File file){
        Integer[] arr=new Integer[Integer.MAX_VALUE-5];

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[4];
            int actuallyRead;
            int num;
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                num = ByteBuffer.wrap(buffer).getInt();
                arr[num]++;
            }

//            int counter=0;
//            while ((actuallyRead = inputStream.read(buffer)) != -1) {
//                num = ByteBuffer.wrap(buffer).getInt();
//                arr[num]++;
//            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        Random random=new Random(System.currentTimeMillis());
        int numRandom=random.nextInt(Integer.MAX_VALUE);
        while (arr[numRandom]==0){
            numRandom=random.nextInt(Integer.MAX_VALUE);
        }
        return numRandom;
    }
}
