package geodb;

import junit.framework.Assert;
import geodb.GeoDB;

import org.junit.Test;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class GeoDBEWKBTest {

    @Test
    public void testGToEWKB() throws ParseException {
        Geometry g = new WKTReader().read("POINT (10 10)");
        g.setSRID(4326);

        // to and from ewkb
        byte[] ewkb = GeoDB.gToEWKB(g);
        Geometry gFromEwkb = GeoDB.gFromEWKB(ewkb);
        Assert.assertTrue(g.equalsExact(gFromEwkb));
        Assert.assertEquals(4326, gFromEwkb.getSRID());
    }
}
