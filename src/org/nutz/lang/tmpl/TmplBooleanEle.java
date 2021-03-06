package org.nutz.lang.tmpl;

import org.nutz.castor.Castors;
import org.nutz.lang.Strings;

class TmplBooleanEle extends TmplDynamicEle<Boolean> {

    private String[] texts;

    public TmplBooleanEle(String key, String fmt, String dft) {
        this.key = key;
        this.texts = Strings.splitIgnoreBlank(Strings.sNull(fmt, "true/false"), "\\/");
        this.dft = null == dft ? false : Boolean.valueOf(dft);
    }

    @Override
    protected String _val(Object val) {
        boolean b = null == val ? dft : Castors.me().castTo(val, Boolean.class);
        return b ? texts[1] : texts[0];
    }

}
