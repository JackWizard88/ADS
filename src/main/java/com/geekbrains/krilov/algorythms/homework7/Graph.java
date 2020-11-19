package com.geekbrains.krilov.algorythms.homework7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    public void addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
    }

    public void addEdges(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String other : others) {
            addEdge(startLabel, other);
        }
    }

    private int indexOf(String vertexLabel) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexLabel.equals(vertexList.get(i).getLabel())) {
                return  i;
            }
        }
        return -1;
    }


    public int getVertexSize() {
        return vertexList.size();
    }

    public void display() {
        for (int i = 0; i < getVertexSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getVertexSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, stack);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(vertex, stack);
            }
            else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);

        visitVertex(vertex, queue);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(vertex, queue);
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    public void findShortestRoute(String startLabel, String destLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label");
        }
        int destIndex = indexOf(destLabel);
        if (destIndex == -1) {
            throw new IllegalArgumentException("Invalid end label");
        }

        System.out.print("Кратчайший маршрут: ");

        Queue<Vertex> queue = new LinkedList<>();

        Vertex vertex = vertexList.get(startIndex);
        Vertex destVertex = vertexList.get(destIndex);

        visitVertex(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(vertex, queue, queue.peek());
                if (vertex.equals(destVertex)) {
                    printRoute(vertex);
                    break;
                }
            }
            else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    private void printRoute(Vertex vertex) {

        Stack<String> stack = new Stack<>();

        while (vertex.getPrevious() != null) {
            stack.push(vertex.getLabel());
            vertex = vertex.getPrevious();
        }

        while (!stack.empty()) {
            System.out.print(" -> " + stack.pop());
        }

    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < getVertexSize(); i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).getVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Vertex vertex, Stack<Vertex> stack) {
        System.out.print(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        System.out.print(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Vertex vertex, Queue<Vertex> queue, Vertex previous) {
        queue.add(vertex);
        vertex.setPrevious(previous);
        vertex.setVisited(true);
    }


}
