package main.java.home;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckDependenciesCompile {

    public static void main(String[] args) {
        System.out.println(canCompile(new String[][]{new String[]{"A", "B"}, new String[]{"A", "C"}, new String[]{"B", "D"}}));
        System.out.println(canCompile(new String[][]{new String[]{"A", "B"}, new String[]{"B", "A"}, new String[]{"C", "A"}}));
        System.out.println(canCompile(new String[][]{new String[]{"A", "B"}, new String[]{"B", "A"}}));
    }

    public static boolean canCompile(String[][] deps) {
        Map<String, Set<String>> root2ChildDependency = new HashMap<>();

        for (String[] depPair : deps) {
            root2ChildDependency.computeIfAbsent(depPair[0], k -> new HashSet<>()).add(depPair[1]);
        }

        Set<String> resolvedDependency = new HashSet<>();
        Set<String> unresolvedDependency = new HashSet<>();

        for (Map.Entry<String, Set<String>> entry : root2ChildDependency.entrySet()) {
            if (!canResolve(entry.getKey(), entry.getValue(), root2ChildDependency, resolvedDependency, unresolvedDependency))
                return false;
        }

        return true;
    }

    public static boolean canResolve(
            String dependency2Resolve,
            Set<String> children,
            Map<String, Set<String>> deps,
            Set<String> resolvedDependency,
            Set<String> unresolvedDependency) {
        unresolvedDependency.add(dependency2Resolve);
        for (String child : children) {
            if (!resolvedDependency.contains(child)) {
                if (unresolvedDependency.contains(child)) return false;
            }
            if (!canResolve(child, deps.getOrDefault(child, Set.of()), deps, resolvedDependency, unresolvedDependency)) {
                return false;
            }
        }
        resolvedDependency.add(dependency2Resolve);
        unresolvedDependency.add(dependency2Resolve);
        return true;
    }

}
