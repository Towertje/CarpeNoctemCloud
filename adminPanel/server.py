import streamlit as st

pg = st.navigation(
    {"Database": [
        st.Page("database_page.py", title="Database")],
        "Tasks": [
            st.Page("index_task_page.py", title="Index Task"),
            st.Page("cleanup_task_page.py", title="Cleanup Task")]
    })

st.title(pg.title)
pg.run()
