package didi.unionfind;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = queries.size();
        double[] result = new double[len];

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            buildGraph(equations.get(i).get(0), equations.get(i).get(1), graph, values[i]);
            buildGraph(equations.get(i).get(1), equations.get(i).get(0), graph, 1.0 / values[i]);
        }

        for (int i = 0; i < queries.size(); i++){
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph);
        }

        return result;
    }

    private void buildGraph(String source, String destination, Map<String, Map<String, Double>> graph, double value) {
        Map<String, Double> edges;

        if (graph.containsKey(source)) {
            edges = graph.get(source);
        } else {
            edges = new HashMap<>();
        }

        edges.put(destination, value);
        graph.put(source, edges);
    }

    private double dfs(String source, String destination, Map<String, Map<String, Double>> graph) {
        if (graph.get(source) == null || graph.get(destination) == null) return -1d;

        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Map<String, Double> value = new HashMap<>();

        stack.push(source);
        value.put(source, 1d);

        String curr;

        while(!stack.isEmpty()){
            curr = stack.pop();
            Map<String, Double> edge = graph.get(curr);
            for (String s : edge.keySet()) {
                value.put(s, value.get(curr) * edge.get(s));
                if (s.equals(destination)) {
                    return value.get(s);
                } else if (!visited.contains(s)) {
                    visited.add(s);
                    stack.push(s);
                }
            }
        }

        return -1d;
    }
}