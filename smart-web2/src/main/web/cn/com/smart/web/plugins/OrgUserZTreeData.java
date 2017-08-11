package cn.com.smart.web.plugins;

import cn.com.smart.utils.StringUtil;

/**
 *  ZTree插件---组织机构与用户树形数据结构类
 * @author lmq
 *
 */
public class OrgUserZTreeData extends ZTreeData {

	@Override
	public String getIconSkin() {
		if(!isParent && !"user".equals(flag)) {
			iconSkin = "org-leaf";
		} else if("user".equals(flag)) {
			iconSkin = "user";
		}
		return super.getIconSkin();
	}

	@Override
	public Boolean getNocheck() {
		nocheck = true;
		if(!StringUtil.isEmpty(checkFlag) && checkFlag.equals(flag)) {
			nocheck = false;
		}
		return super.getNocheck();
	}
}
