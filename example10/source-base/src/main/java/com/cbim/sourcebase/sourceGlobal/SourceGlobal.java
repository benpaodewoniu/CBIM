package com.cbim.sourcebase.sourceGlobal;

import java.util.concurrent.ConcurrentLinkedDeque;

public class SourceGlobal {

    public static ConcurrentLinkedDeque<byte[]> dataQueue = new ConcurrentLinkedDeque();

}
