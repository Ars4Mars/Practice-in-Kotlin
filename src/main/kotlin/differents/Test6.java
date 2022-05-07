package differents;

import java.util.Objects;

public class Test6 {

    public String field1;
    public Integer field2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test6 test6 = (Test6) o;
        return Objects.equals(field1, test6.field1) && Objects.equals(field2, test6.field2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2);
    }

    public static void main(String[] args) {

    }
}
