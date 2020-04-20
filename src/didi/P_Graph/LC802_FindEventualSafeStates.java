package src.didi.P_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC802_FindEventualSafeStates {
    enum State {
        SAFE,
        UNSAFE,
        VISITING,
        UNKNOWN
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        // unsafe if there is a circle
        List<Integer> res = new ArrayList<>();
        State[] states = new State[graph.length];
        Arrays.fill(states, State.UNKNOWN);

        for (int i = 0; i < graph.length; i++) {
            if(dfs(states, i, graph) == State.SAFE) res.add(i);
        }

        return res;
    }

    private State dfs (State[] s, int curr, int[][] g) {
        if (s[curr] == State.VISITING) return State.UNSAFE;
        if (s[curr] != State.UNKNOWN) return s[curr];

        s[curr] = State.VISITING;

        for (int nei : g[curr]) {
            if (dfs(s, nei, g) == State.UNSAFE){
                s[curr] = State.UNSAFE;
                return State.UNSAFE;
            }
        }

        s[curr] = State.SAFE;
        return State.SAFE;
    }
}
