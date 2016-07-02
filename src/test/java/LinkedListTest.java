import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    LinkedList list = new LinkedList("head node");

    @Test
    public void testHeadNode() {
        assertEquals("head node", list.head.data);
    }

    @Test
    public void testInsertNode() {
        list.insert("node 1");
        assertEquals("node 1", list.head.next.data);
    }

    @Test
    public void testFind() {
        assertEquals("head node", list.find("head node").data);
        list.insert("node 1");
        assertEquals("node 1", list.find("node 1").data);
    }

    @Test
    public void testUpdate() {
        list.update("head node", "updated node");
        assertEquals("updated node", list.head.data);
    }

    @Test
    public void testFindParent() {
        list.insert("node 1");
        Node node = list.find("node 1");
        assertEquals(list.head, list.findParent(node.data));
    }

    @Test
    public void testDelete() {
        list.insert("node 1");
        list.delete("node 1");
        assertEquals(list.head.next, null);

        list.insert("node 1");
        list.insert("node 2");
        list.delete("node 2");
        assertEquals(list.find("node 2"), null);
    }

    @Test
    public void testPop() {
        list.insert("node 1");
        Node node = list.find("node 1");
        assertEquals(node, list.pop());

        list.insert("node 1");
        list.insert("node 2");
        list.insert("node 3");
        Node nodeThree = list.find("node 3");
        Node nodeTwo = list.find("node 2");
        assertEquals(nodeThree, list.pop());
        assertEquals(nodeTwo, list.pop());
    }

    @Test
    public void testTail() {
        list.insert("node 1");
        Node tail = list.tail();

        assertEquals("node 1", tail.data);
    }

    @Test
    public void testLength() {
        assertEquals(1, list.length());

        list.insert("node 1");

        assertEquals(2, list.length());

        list.insert("node 2");

        assertEquals(3, list.length());
    }
}
