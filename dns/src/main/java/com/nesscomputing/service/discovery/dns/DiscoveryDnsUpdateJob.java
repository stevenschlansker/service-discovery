package com.nesscomputing.service.discovery.dns;

import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.Type;
import org.xbill.DNS.Update;
import org.xbill.DNS.utils.base64;

public class DiscoveryDnsUpdateJob
{
    public static void main(String[] args) throws Exception
    {
        long id = System.currentTimeMillis();
        System.out.println("id is " + id);

        Name zone = Name.fromString("dyn.dev.nessops.net.");
        Name host = Name.fromString("testing", zone);

        Update update = new Update(zone);
        update.replace(host, Type.TXT, 900, "testing! " + id);

        Resolver res = new SimpleResolver("icinga1a.nessops.net");
        res.setTSIGKey(new TSIG(Name.fromString("internal."), base64.fromString("iv/Fk8n+1MZafFlArE8eQA==")));
        res.setTCP(true);

        Message response = res.send(update);

        System.out.println(response);
    }
}
