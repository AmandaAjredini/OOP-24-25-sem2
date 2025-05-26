package extrole;

import java.util.ArrayList;
import java.util.List;

public class ExternalRoleList<R extends ExternalRole> {
    private List<R> list = new ArrayList<>(); 
 
    public void add(R r) {
        list.add(r);
    }

    protected R getById(int id) {
        return list.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }
}
