function getTimeText(date) {
      let now=new Date();
      let gmtCreateDate=new Date(date);
      let t=(now.getTime()-gmtCreateDate.getTime())/1000;
      let gmtCreateText;
      if(t < 60){
          gmtCreateText='刚刚';
      }else if(t < 60 * 60){
          gmtCreateText = parseInt(t / 60)+'分钟前';
      }else if(t < 60 * 60 * 24){
          gmtCreateText= parseInt(t / 60 / 60)+ '小时前';
      }else {
          gmtCreateText = parseInt(t / 60 /60 /24)+ '天前';
      }
      return gmtCreateText;
}