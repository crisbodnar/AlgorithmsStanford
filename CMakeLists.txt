cmake_minimum_required(VERSION 3.6)
project(AlgorithmsStanford)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
    "Week1 - MergeSort/ArrayInversions.class"
    "Week1 - MergeSort/ArrayInversions.java"
    "Week1 - MergeSort/IntegerArray.txt"
    "Week1 - MergeSort/liste.out"
    "Week1 - MergeSort/Litere.class"
    "Week1 - MergeSort/litere.in"
    "Week1 - MergeSort/litere.out"
    "Week1 - MergeSort/LitereInfoarena.class"
    "Week1 - MergeSort/Main.class"
    "Week1 - MergeSort/Main.java"
    "Week1 - MergeSort/test.txt"
    "Week2 - QuickSort/QuickSort.class"
    "Week2 - QuickSort/QuickSort.java"
    "Week2 - QuickSort/QuickSort.txt"
    Week3-MinimumCut/input.txt
    Week3-MinimumCut/input2.txt
    Week3-MinimumCut/MinCut\$1.class
    Week3-MinimumCut/MinCut\$Edge.class
    Week3-MinimumCut/MinCut\$Graph\$1.class
    Week3-MinimumCut/MinCut\$Graph.class
    Week3-MinimumCut/MinCut\$Vertex.class
    Week3-MinimumCut/MinCut.class
    Week3-MinimumCut/MinCut.java
    Week3-MinimumCut/MinimumCut.py
    Week4-StronglyConnectedComponents/input.txt
    Week4-StronglyConnectedComponents/StronglyConnectedComponents\$1.class
    Week4-StronglyConnectedComponents/StronglyConnectedComponents.class
    Week4-StronglyConnectedComponents/StronglyConnectedComponents.java)

add_executable(AlgorithmsStanford ${SOURCE_FILES})