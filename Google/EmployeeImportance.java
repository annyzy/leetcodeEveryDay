import java.util.*;

class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int ans = dfs(id);
        return ans;
    }

    public int dfs(int id) {
        int ans = map.get(id).importance;
        for (Integer sub : map.get(id).subordinates) {
            ans = ans + dfs(sub);
        }
        return ans;
    }
}
