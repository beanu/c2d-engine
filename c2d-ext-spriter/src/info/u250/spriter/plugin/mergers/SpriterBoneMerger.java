package info.u250.spriter.plugin.mergers;

import info.u250.spriter.dom.Bone;
import info.u250.spriter.dom.BoneRef;
import info.u250.spriter.dom.Key;
import info.u250.spriter.plugin.objects.SpriterBone;

public class SpriterBoneMerger implements Merger<BoneRef, Key, SpriterBone> {

	public SpriterBone merge(BoneRef ref, Key key) {

		Bone obj = key.getBone();

		SpriterBone bone = new SpriterBone();
		bone.setTimeline(ref.getTimeline());
		bone.setParent(ref.getParent());
		bone.setId(ref.getId());
		bone.setAngle(obj.getAngle().floatValue());
		bone.setScaleX(obj.getScaleX().floatValue());
		bone.setScaleY(obj.getScaleY().floatValue());
		bone.setX(obj.getX().floatValue());
		bone.setY(obj.getY().floatValue());
		bone.setSpin(key.getSpin());
		return bone;
	}

}
