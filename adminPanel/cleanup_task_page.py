import pandas as pd
import streamlit as st

import util.dbLayer as dbLayer

db = dbLayer.DbLayer()
cleanup_logs = [[str(end - start), start, end, indexed] for [start, end, indexed] in
                db.get_cleanup_tables_limit_10()]

df = pd.DataFrame(
    data=cleanup_logs,
    columns=["Duration", "Started", "Ended", "Files Deleted"]
)

st.dataframe(df, hide_index=True)
