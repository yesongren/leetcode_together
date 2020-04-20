package songren.Graph;

import java.util.List;

/**
 * Created by yesongren on 2020/4/20
 * 841. Keys and Rooms
 */
public class LC841_KeysAndRooms {
    private boolean[] visited;
    private List<List<Integer>> rooms;
    private int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        this.rooms = rooms;
        count = 0;

        dfs(0);

        return count == rooms.size();
    }

    private void dfs(int i) {
        if (!visited[i]) {
            visited[i] = true;
            count++;
        } else {
            return;
        }
        List<Integer> keys = rooms.get(i);
        for (Integer key : keys) {
            dfs(key);
        }
    }
}
