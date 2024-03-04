package processes;

import java.util.List;

import components.Connection;

public class ForwardPropagate {
    /**
     * Method to propagate values through all connections
     *
     * @param connections List of lists representing the connections
     * @return Updated List of Lists representing the connections
     */
    public static List<List<Connection>> propagate(List<List<Connection>> connections) {

        for (List<Connection> list : connections) {
            list.forEach(connection -> {connection.setValue(connection.weight(true));});
        }

        System.out.println("propagate: done");
        return connections;
    }
}
