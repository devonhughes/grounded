/*  LOG FROM BLAMMO
What rolls down stairs alone or in pairs,
rolls over your neighbor's dog?
What's great for a snack, And fits on your back?
It's log, log, log

It's log, log,
It's big, it's heavy, it's wood.
It's log, log, it's better than bad, it's good."

Everyone wants a log
You're gonna love it, log
Come on and get your log
Everyone needs a log
 */
package grounded.business;

import java.io.Serializable;

/**
 *
 * @author Primary
 */
public class Log implements Serializable{
    private String mLog;
    private String scratchLog;
    private String browserLog;

    // no args contructor
    public Log(){
        mLog = "";
        scratchLog = "";
        browserLog = "";
    }
    /**
     * @return the mLog
     */
    public String getmLog() {
        return mLog;
    }

    /**
     * @param mLog the mLog to set
     */
    public void setmLog(String mLog) {
        this.mLog = mLog;
    }

    /**
     * @return the scratchLog
     */
    public String getScratchLog() {
        return scratchLog;
    }

    /**
     * @param scratchLog the scratchLog to set
     */
    public void setScratchLog(String scratchLog) {
        this.scratchLog = scratchLog;
    }

    /**
     * @return the browserLog
     */
    public String getBrowserLog() {
        return browserLog;
    }

    /**
     * @param browserLog the browserLog to set
     */
    public void setBrowserLog(String browserLog) {
        this.browserLog = browserLog;
    }
    
    
}
