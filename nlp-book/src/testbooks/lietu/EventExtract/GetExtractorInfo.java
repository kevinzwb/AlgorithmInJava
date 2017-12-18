package testbooks.lietu.EventExtract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 根据标题提取信息,获得目的地和时间。
 * 
 * @author wolf
 */
public class GetExtractorInfo {

	/**
	 * 根据提取QQ信息
	 * 
	 * @param message
	 * @return destination
	 */
	public static void main(String[] args) {
		// GetQQinfo("发 起 人：小飞峡； 手机：13051898607；qq号:909902845；人数限制51人 ");
		// GetMobileInfo("发 起 人：小飞峡； 手机：13051898607；qq号:909902845；人数限制51人 ");
		// GetConvnorInfo("发 起 人： 镇流");
		// GetPeopleCountInfo("人数限制： 25人");

		// TourInfo ss = getContractInfo("广州集合地点：越秀区人民北路691号金信大厦B座2205室 ");
		// TourInfo ss = getContractInfo("25号哈尔滨集合 ");
//	 	TourInfo ss = getContractInfo("可以加我Q？  447567368");
//		 TourInfo ss = getContractInfo("QQ联系：七七一6一621");
//		 TourInfo ss = getContractInfo("可以加我QQ；284109400 ");
		 TourInfo ss = getContractInfo("　e-mail: jshedu@126.com ");
//		 System.out.println(ss);
	}

	public static TourInfo getContractInfo(String message) {
		if (message == null)
			return null;

		ArrayList<DocToken> lst = DocTagger.tag(message);
		Iterator<DocToken> it = lst.iterator();
		DocToken next = null;
		Pattern p = null;
		Matcher m = null;
		boolean findmsn = false;
		boolean findQQ = false;
		boolean findMobile = false;
		boolean findConvenor = false;
		boolean findPeopleNumber = false;
		boolean findEmailInfo = false;
		boolean findtelphone = false;
		// boolean findCityInfo = false;
		boolean findDetailAddressInfo = false;
		String qqInfo = "";
		String phoneInfo = "";
		String convenorInfo = "";
		String peoplenumberInfo = "";
		String emailInfo = "";
		String detailAddressInfo = "";
		String msnInfo = "";
		String telephone = "";

		while (it.hasNext()) {

			next = it.next();

//			 System.out.println("子信息项:" + next.toString());

			if (next.match(DocType.qqinfo)) {
				if (findQQ == false) {
					// System.out.println(qqInfo);
					qqInfo = next.getTermText();
					findQQ = true;
					// System.out.println("QQ:" + next.getTermText());
				}
			} else if (next.match(DocType.mobiletelephone)) {
				if (findMobile == false) {
					phoneInfo = next.getTermText();
					findMobile = true;
					// System.out.println("电话:" + next.getTermText());
				}
			} else if (next.match(DocType.convenor)) {
				if (findConvenor == false) {
					convenorInfo = next.getTermText();
					findConvenor = true;
				}
			} else if (next.match(DocType.peoplenumber)) {
				if (findPeopleNumber == false) {
					peoplenumberInfo = next.getTermText();
					findPeopleNumber = true;
				}
			} else if (next.match(DocType.emailInfo)) {
				if (findEmailInfo == false) {
					emailInfo = next.getTermText();
					findEmailInfo = true;
				}
			} else if (next.match(DocType.MSNInfo)) {
				if (findmsn == false) {
					msnInfo = next.getTermText();
					findmsn = true;
				}
			} else if (next.match(DocType.telephone)) {
				if (findtelphone == false) {
					telephone = next.getTermText();
					findtelphone = true;
					// System.out.println("固定电话"+next.getTermText());
				}
			} else if (next.match(DocType.DetailAddressInfo)) {
				if (findDetailAddressInfo == false) {
					detailAddressInfo = next.getTermText();
					findDetailAddressInfo = true;
					// System.out.println("详细地址:" + next.getTermText());
				}
			} else if (next.match(DocType.Num)) {
				if (findMobile == false) {
					phoneInfo = next.getTermText();
					findMobile = true;
				}
			}
		}

		/**
		 * 根据长度取舍多个QQ,电话
		 */
		qqInfo = qqInfo.trim();
		phoneInfo = phoneInfo.trim();
		if (qqInfo.length() > 13) {
			String[] filterString = qqInfo.split("\t|　|-|\\s");
			if (filterString.length > 1 && filterString[0].length() > 5
					&& filterString[0].length() < 11) {
				qqInfo = filterString[0];
			}
		}
		if (phoneInfo.length() > 15) {
			String[] filterStr = phoneInfo.split("\t|　|-|\\s");
			if (filterStr.length > 1 && filterStr[0].length() >= 11) {
				phoneInfo = filterStr[0];
			}
		}

		p = Pattern.compile("\\s|\t| |\r|\n|　|-|－|】|。|——");

		m = p.matcher(qqInfo);
		qqInfo = m.replaceAll("");

		m = p.matcher(convenorInfo);
		convenorInfo = m.replaceAll("");

		m = p.matcher(peoplenumberInfo);
		peoplenumberInfo = m.replaceAll("");

		m = p.matcher(emailInfo);
		emailInfo = m.replaceAll("");

		m = p.matcher(detailAddressInfo);
		detailAddressInfo = m.replaceAll("");

		m = p.matcher(phoneInfo);
		phoneInfo = m.replaceAll("");

		m = p.matcher(msnInfo);
		msnInfo = m.replaceAll("");

		m = p.matcher(telephone);
		telephone = m.replaceAll("");

		// System.out.println("QQ:长度:" + qqInfo.trim().length() + "信息:" +
		// qqInfo);
		// System.out.println("电话:" + phoneInfo);
		// System.out.println("召集人:" + convenorInfo);
		// System.out.println("人数:" + peoplenumberInfo);
		// System.out.println("email:" + emailInfo);
		// System.out.println("城市:" + cityInfo);
		// System.out.println("详细地址:" + detailAddressInfo);

		/* 对QQ号进行过滤 */
		if ((qqInfo.trim().length() > 10) || (qqInfo.trim().length() < 5)) {
			qqInfo = "";
		}

		/* 对电话号码进行过滤 */
		if (phoneInfo.length() != 11) {
			phoneInfo = "";
		}
		/* 对固定电话进行过滤 */
		if ((telephone.trim().length() > 14)
				|| (telephone.trim().length() < 10)) {
			telephone = "";
		}

		// if (cityInfo == null) System.out.println("OK");
		// else System.out.println("BAD");

		p = Pattern.compile("1[3,5,8][0-9]{9}"); // 正则表达式
		m = p.matcher(phoneInfo);
		if (!m.matches()) {
			phoneInfo = "";
		}
		// else if ((cityInfo == null) || (cityInfo.trim().length() == 0))/*
		// 如果电话号码是有效数字,并且city字段为空 ，则查出电话号码所在地，并填入出发城市字段 */
		// {
		// System.out.println("Query City");
		// System.out.println(phoneInfo);
		// cityInfo = StartCityByPhone.getStartCityByPhone(phoneInfo);
		// if (cityInfo == null) cityInfo = "";
		// System.out.println("City:" + cityInfo);
		// }

		if ((convenorInfo.toString().trim().length() > 10)
				|| (convenorInfo.toString().trim().length() == 0)) {
			convenorInfo = "";
		}

		if (peoplenumberInfo.indexOf("1") == -1
				&& peoplenumberInfo.indexOf("2") == -1
				&& peoplenumberInfo.indexOf("3") == -1
				&& peoplenumberInfo.indexOf("4") == -1
				&& peoplenumberInfo.indexOf("5") == -1
				&& peoplenumberInfo.indexOf("6") == -1
				&& peoplenumberInfo.indexOf("7") == -1
				&& peoplenumberInfo.indexOf("8") == -1
				&& peoplenumberInfo.indexOf("9") == -1
				&& peoplenumberInfo.indexOf("不限") == -1) {
			peoplenumberInfo = "";
		} else {
			// System.out.println("peoplenumberInfo" + peoplenumberInfo);
			if (peoplenumberInfo.indexOf("人") == -1
					&& peoplenumberInfo.indexOf("不限") == -1)
				peoplenumberInfo += "人";
			peoplenumberInfo = peoplenumberInfo.toString().trim();
		}

		/* 使用正则表达式检查邮件的规范性 */
		p = Pattern
				.compile("^([a-z0-9A-Z]+[|_|-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"); // 正则表达式
		m = p.matcher(emailInfo);
		if (!m.matches()) {
			emailInfo = "";
		}

		m = p.matcher(msnInfo);
		if (!m.matches()) {
			msnInfo = "";
		}

		if (qqInfo == null)
			qqInfo = "";
		if (phoneInfo == null)
			phoneInfo = "";
		if (convenorInfo == null)
			convenorInfo = "";
		if (peoplenumberInfo == null)
			peoplenumberInfo = "";
		if (emailInfo == null)
			emailInfo = "";
		if (msnInfo == null)
			msnInfo = "";
		if (detailAddressInfo == null)
			detailAddressInfo = "";
		if (telephone == null)
			telephone = "";

		TourInfo info = new TourInfo();
		info.setQq(qqInfo.trim());
		info.setMobile(phoneInfo.trim());
		info.setTelephone(telephone.trim());
		info.setLeader(convenorInfo.trim());
		info.setCounter(peoplenumberInfo.trim());
		info.setMsninfo(msnInfo.trim());
		info.setEmail(emailInfo.trim());
		info.setDetailAddress(detailAddressInfo.trim());
		System.out.println(info);
		return info;
	}
}